package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.Bet;
import com.itensis.snailRace.Data.Gambler;
import com.itensis.snailRace.Data.Snail;
import com.itensis.snailRace.db.Db;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Calculator {

    void calculateSnailDistance(){
        for(Snail currentSnail : Db.getSnails()){
            if(currentSnail.getDistance() < 101){
                currentSnail.setLastJump(ThreadLocalRandom.current().nextDouble(0.1, 5) + 1);
                currentSnail.setDistance(currentSnail.getDistance() + currentSnail.getLastJump());
            }
        }
    }

    void calculateSnailTime(){
        for(Snail currentSnail : Db.getSnails()){
            if(currentSnail.getDistance() > 100 && !currentSnail.isDone()){
                double lastPosition = currentSnail.getDistance() - currentSnail.getLastJump();
                double neededDistance = 100 - lastPosition;
                currentSnail.setTime(currentSnail.getTime() + (neededDistance / currentSnail.getLastJump()));
                currentSnail.setDone(true);
            }else if(!currentSnail.isDone()) {
                currentSnail.setTime(currentSnail.getTime() + 1);
            }
        }
    }

    void calculateRanks(){
        List<Snail> sortedSnails = sortSnailList();
        int rank = 1;
        int sameRank = 0;
        for(int i = 0; i < sortedSnails.size(); i++){
            if(i == 0){
                sortedSnails.get(i).setRank(rank);
            }else{
                Snail currentSnail = sortedSnails.get(i);
                Snail currentSnail2 = sortedSnails.get(i - 1);
                if(currentSnail.getTime() == currentSnail2.getTime()){
                    currentSnail.setRank(rank);
                    currentSnail2.setRank(rank);
                    sameRank++;
                }else{
                    rank = rank + sameRank + 1;
                    currentSnail.setRank(rank);
                    sameRank = 0;
                }
            }
        }
    }

    private List<Snail> sortSnailList(){
        return Db.getSnails().stream()
            .sorted(Comparator.comparingDouble(Snail::getTime))
            .collect(Collectors.toList());
    }

    void calculateGamblerBets(){
        for(Gambler currentGambler : Db.getActiveGamblers()) {
            long wonAmount = 0;
            List<Bet> currentGamblerBets = Db.getBettingOffice().getBetsById(currentGambler);
            for(Bet currentBet : currentGamblerBets){
                if(currentBet.getRank() == currentBet.getSnail().getRank()){
                    wonAmount = currentBet.getBetAmount() * 2 + wonAmount;
                }
            }
            currentGambler.setBankBalance(wonAmount + currentGambler.getBankBalance());
        }
    }
}
