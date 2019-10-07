package com.itensis.snailRace.console;

import com.itensis.snailRace.Data.Messages;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    private Validator validator = new Validator();
    private Scanner inputScanner = new Scanner(System.in);

    public int askIntInRange(int min, int max, Messages message){
        boolean inputIsCorrect = false;
        int userInputInt = 0;
        Printer.printMessage(message);
        while (!inputIsCorrect){
            String userInput = inputScanner.nextLine();
            if(inputIsCorrect = validator.isInt(userInput)){
                userInputInt = Integer.parseInt(userInput);
            }else {
                continue;
            }
            inputIsCorrect = validator.validateIntInRange(min, max, userInputInt);
        }
        return userInputInt;
    }

    public long askLongInRange(long min, long max, Messages message){
        boolean inputIsCorrect = false;
        long userInputLong = 0;
        Printer.printMessage(message);
        while (!inputIsCorrect){
            String userInput = inputScanner.nextLine();
            if(inputIsCorrect = validator.isLong(userInput)){
                userInputLong = Long.parseLong(userInput);
            }else {
                continue;
            }
            inputIsCorrect = validator.validateLongInRange(min, max, userInputLong);
        }
        return userInputLong;
    }

    public int askIntInList(List<Integer> integerList, Messages message, int modifier){
        boolean inputIsCorrect = false;
        int userInputInt = 0;
        Printer.printMessage(message);
        while (!inputIsCorrect){
            String userInput = inputScanner.nextLine();
            if(inputIsCorrect = validator.isInt(userInput)){
                userInputInt = Integer.parseInt(userInput);
            }else {
                continue;
            }
            inputIsCorrect = validator.validateIntInList(userInputInt - modifier, integerList);
        }
        return userInputInt - modifier;
    }

    public String askString(Messages message){
        Printer.printMessage(message);
        return inputScanner.nextLine();
    }

    public boolean askYes(Messages message){
        boolean inputIsCorrect = false;
        String input = "";
        Printer.printMessage(message);
        while(!inputIsCorrect){
          input = inputScanner.nextLine();
          inputIsCorrect = validator.isYesOrNo(input);
        }
        return input.equals("y");
    }
}
