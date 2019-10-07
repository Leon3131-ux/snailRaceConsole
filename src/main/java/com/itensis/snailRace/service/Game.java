package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.Messages;
import com.itensis.snailRace.console.Printer;
import com.itensis.snailRace.console.UserInput;
import com.itensis.snailRace.db.Db;

public class Game {

    private final static String gamblerFilePath = "C:/JavaGames/SnailRace/Players.txt";
    private final static String snailNameFilePath = "C:/JavaGames/SnailRace/SnailNames.txt";

    private UserInput userInput;
    private GamblerReader gamblerReader;
    private SnailCreator snailCreator;
    private BetReader betReader;
    private Calculator calculator;
    private FileWriter fileWriter;
    private EndChecker endChecker;

    public Game(UserInput userInput, GamblerReader gamblerReader, SnailCreator snailCreator, BetReader betReader, Calculator calculator, FileWriter fileWriter, EndChecker endChecker){
        this.userInput = userInput;
        this.gamblerReader = gamblerReader;
        this.snailCreator = snailCreator;
        this.betReader = betReader;
        this.calculator = calculator;
        this.fileWriter = fileWriter;
        this.endChecker = endChecker;
    }

    public void startGame(){ //TODO rename
        createLists();

        do{
            gamblerReader.getPlayingGamblers();
            betReader.requestBets();
            printGame();
            calculator.calculateRanks();
            calculator.calculateGamblerBets();
            Printer.printSnailRanks();
            Printer.clearConsole(1);
            Printer.printGamblers();
            Db.resetSnails();
        }while (userInput.askYes(Messages.PLAY_ANOTHER_GAME));
        fileWriter.writeGamblersToFile();
    }

    void printGame(){
        while(!endChecker.isGameEnd()){
            Printer.printGame();
            calculator.calculateSnailDistance();
            calculator.calculateSnailTime();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void createLists(){
        snailCreator.createSnailList(userInput.askIntInRange(0, 61, Messages.ENTER_AMOUNT_SNAILS));
        gamblerReader.readExistingGamblers();
    }

}
