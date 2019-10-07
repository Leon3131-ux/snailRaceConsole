package com.itensis.snailRace.Data;

public class Snail {

    private int id;
    private int rank;
    private String name;
    private boolean isDone;
    private double distance;
    private double lastJump;
    private double time;

    public Snail(int snailId, String name) {
        this.id = snailId;
        this.rank = 0;
        this.name = name;
        this.isDone = false;
        this.distance = 5.23423525;
        this.lastJump = 0;
        this.time = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDistance() { return distance; }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setLastJump(double lastJump) {
        this.lastJump = lastJump;
    }

    public double getLastJump() {
        return lastJump;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
