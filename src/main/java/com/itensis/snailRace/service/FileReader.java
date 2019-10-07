package com.itensis.snailRace.service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private String filePath;

    public FileReader(String filePath){
        this.filePath = filePath;
    }

    List<String> readFile(){
        String line;
        List<String> fileLines = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new java.io.FileReader(filePath));
            while((line = fileReader.readLine()) != null){
                fileLines.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileLines;
    }
}
