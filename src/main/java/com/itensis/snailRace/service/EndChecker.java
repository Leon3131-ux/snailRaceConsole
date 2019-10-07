package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.Snail;
import com.itensis.snailRace.db.Db;

public class EndChecker {

    boolean isGameEnd(){
        return Db.getSnails().stream().allMatch(Snail::isDone);
    }
}
