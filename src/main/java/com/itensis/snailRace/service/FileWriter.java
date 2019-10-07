package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.Gambler;
import com.itensis.snailRace.db.Db;

import java.io.IOException;

public class FileWriter {

    private String path;

    public FileWriter(String path){
        this.path = path;
    }

    void writeGamblersToFile(){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(path);
            for(Gambler currentGambler : Db.getGamblers()){
                writeGamblerToFile(fileWriter, currentGambler);
            }
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeGamblerToFile(java.io.FileWriter fileWriter, Gambler currentGambler) throws IOException {
        fileWriter.write(
        currentGambler.getName() +
            " " +
            currentGambler.getId() +
            " " +
            currentGambler.getBankBalance() +
            System.lineSeparator()
        );
    }
}
