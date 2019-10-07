package com.itensis.snailRace.db;

import com.itensis.snailRace.Data.BettingOffice;
import com.itensis.snailRace.Data.Gambler;
import com.itensis.snailRace.Data.Snail;

import java.util.*;
import java.util.stream.Collectors;

public class Db {

    private static List<Snail> snails = new ArrayList<>();
    private static List<Gambler> gamblers = new ArrayList<>();
    private static BettingOffice bettingOffice = new BettingOffice();

    public static void saveSnail(Snail snail){
        snails.add(snail);
    }

    public static void saveGambler(Gambler gambler){
        for(Gambler currentGambler : gamblers){
            if(currentGambler.getId() == gambler.getId()){
                gamblers.set(gamblers.indexOf(currentGambler), gambler);
                return;
            }
        }
        gamblers.add(gambler);
    }

    public static Optional<Gambler> getHighestGamblerId(){
        return gamblers.stream().max(Comparator.comparingInt(Gambler::getId));
    }

    public static List<Snail> getSnails() {
        return snails;
    }

    public static List<Gambler> getGamblers() {
        return gamblers;
    }

    public static List<Gambler> getActiveGamblers() {
        return gamblers.stream().filter(Gambler::isActive).collect(Collectors.toList());
    }

    public static Optional<Gambler> getGambler(String name){
        return gamblers.stream().filter(gambler -> gambler.getName().equals(name)).findFirst();
    }

    public static List<Integer> getSnailIds(){
        return snails.stream().map(Snail::getId).collect(Collectors.toList());
    }

    public static Snail getSnail(int snailId) {
        return snails.stream().filter(snail -> snail.getId() == snailId).findFirst().orElseThrow(RuntimeException::new);
    }

    public static BettingOffice getBettingOffice() {
        return bettingOffice;
    }

    public static void resetSnails(){
        for(Snail currentSnail : snails){
            currentSnail.setDone(false);
            currentSnail.setTime(0);
            currentSnail.setDistance(0);
            currentSnail.setLastJump(0);
        }
    }
}
