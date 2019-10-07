package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.Gambler;
import com.itensis.snailRace.Data.Messages;
import com.itensis.snailRace.console.UserInput;
import com.itensis.snailRace.db.Db;

import java.util.List;
import java.util.Optional;

public class GamblerReader {

    private FileReader fileReader;
    private UserInput userInput;

    public GamblerReader(UserInput userInput, FileReader fileReader) {
        this.userInput = userInput;
        this.fileReader = fileReader;
    }

    void readExistingGamblers(){
        List<String> gamblerAttributeList = fileReader.readFile();
        for(String attributeLine : gamblerAttributeList){
            String[] attributes = attributeLine.split(" ");
            int id = Integer.parseInt(attributes[1]);
            long balance = Long.parseLong(attributes[2]);
            Gambler gambler = new Gambler(id, balance, attributes[0]);
            Db.saveGambler(gambler);
        }
    }

    void getPlayingGamblers(){ //TODO rename
        while(true) {
            String gamblerName = userInput.askString(Messages.ENTER_NAME);
            boolean gamblerExists = Db.getGamblers().stream().anyMatch(Gambler -> gamblerName.equals(Gambler.getName()));
            if (gamblerExists) {
                Optional<Gambler> optionalGambler = Db.getGambler(gamblerName);
                optionalGambler.ifPresent(this::saveGamblerAsActive);
                if(continueEnterUser()){
                    continue;
                }
            }else{
                createNewGambler(gamblerName);
                if(continueEnterUser()){
                    continue;
                }
            }
            break;
        }
    }

    private void saveGamblerAsActive(Gambler gambler) {
        if(gambler.getBankBalance() == 0){
            gambler.setBankBalance(500);
        }
        gambler.setActive(true);
        Db.saveGambler(gambler);
    }

    private void createNewGambler(String name) {
        Optional<Gambler> optionalGambler = Db.getHighestGamblerId();
        if(optionalGambler.isPresent())
            saveGamblerAsActive(new Gambler(optionalGambler.get().getId() + 1, 500, name));
        else
            Db.saveGambler(new Gambler(500, name));
    }

    private boolean continueEnterUser() {
        return userInput.askYes(Messages.ENTER_MORE_GAMBLERS);
    }

}
