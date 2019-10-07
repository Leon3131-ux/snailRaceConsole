package com.itensis.snailRace;

import com.itensis.snailRace.console.UserInput;
import com.itensis.snailRace.service.*;

public class Main{

    public static void main(String[] args) {
        String gamblerFilePath = "C:/JavaGames/SnailRace/Players.txt";
        String snailNameFilePath = "C:/JavaGames/SnailRace/SnailNames.txt";

        UserInput userInput = new UserInput();
        GamblerReader gamblerReader = new GamblerReader(userInput, new FileReader(gamblerFilePath));
        SnailCreator snailCreator = new SnailCreator(new FileReader(snailNameFilePath));
        BetReader betReader = new BetReader(userInput);
        Calculator calculator = new Calculator();
        FileWriter fileWriter = new FileWriter(gamblerFilePath);
        EndChecker endChecker = new EndChecker();


        Game game = new Game(userInput, gamblerReader, snailCreator, betReader, calculator, fileWriter, endChecker);
        game.startGame();
    }

}
