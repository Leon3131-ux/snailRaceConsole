package com.itensis.snailRace.Data;

public class Gambler {

    private int id;
    private long bankBalance;
    private String name;
    private boolean active;

    public Gambler(int id, long bankBalance, String name) {
        this.id = id;
        this.bankBalance = bankBalance;
        this.name = name;
        this.active = false;
    }

    public Gambler(long bankBalance, String name){
        this.id = 0;
        this.bankBalance = bankBalance;
        this.name = name;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public long getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(long bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
