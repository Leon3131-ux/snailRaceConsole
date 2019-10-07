package com.itensis.snailRace.Data;

public class Bet {

    private Snail snail;
    private Gambler gambler;
    private long betAmount;
    private int rank;

    public Bet(Gambler gambler, Snail snail, long betAmount, int rank) {
        this.snail = snail;
        this.gambler = gambler;
        this.betAmount = betAmount;
        this.rank = rank;
    }

    Gambler getGambler() {
        return gambler;
    }

    public long getBetAmount() {
        return betAmount;
    }

    public Snail getSnail() {
        return snail;
    }

    public int getRank() {
        return rank;
    }
}
