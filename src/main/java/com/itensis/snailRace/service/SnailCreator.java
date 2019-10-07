package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.Snail;
import com.itensis.snailRace.console.UserInput;
import com.itensis.snailRace.db.Db;

import java.util.Collections;
import java.util.List;

public class SnailCreator {

    private FileReader fileReader;

    public SnailCreator(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    void createSnailList(int amount) { //TODO rename
        List<String> names = fileReader.readFile();
        Collections.shuffle(names);
        for (int i = 0; i < amount; i++) {
            Db.saveSnail(new Snail(i, names.get(i)));
        }
    }
}
