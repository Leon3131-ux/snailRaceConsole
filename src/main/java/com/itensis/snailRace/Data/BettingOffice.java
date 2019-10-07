package com.itensis.snailRace.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BettingOffice {

    private List<Bet> bets;

    public BettingOffice() {
        this.bets = new ArrayList<>();
    }

    public void saveBet(Bet bet){
        bets.add(bet);
    }

    public List<Bet> getBetsById(Gambler gambler){
        return bets.stream()
            .filter(bet -> bet.getGambler() == gambler)
            .collect(Collectors.toList());

    }

}
