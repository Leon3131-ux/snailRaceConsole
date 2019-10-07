package com.itensis.snailRace.console;

import com.itensis.snailRace.Data.Gambler;
import com.itensis.snailRace.Data.Messages;
import com.itensis.snailRace.Data.Snail;
import com.itensis.snailRace.db.Db;

public class Printer {

    private static String snailSymbol = "ö";

    static void printMessage(Messages message){
        if(message != Messages.EMPTY) {
            System.out.println(message.getMessage());
        }
    }

    public static void printSnails(){
        for(Snail currentSnail : Db.getSnails()){
            System.out.println(currentSnail.getName() + ", " + (currentSnail.getId() + 1));
        }
    }

    public static void printMessage(String string, Messages message){
        System.out.println(string + " " + message.getMessage());
    }

    public static void printMessage(long longToPrint, Messages message){
        if(message != Messages.EMPTY){
            System.out.println(message.getMessage() + " " + longToPrint);
        }
    }

    public static void printGame(){
        clearConsole(20);
        for(Snail currentSnail : Db.getSnails()){
            if(currentSnail.getDistance() < 100){
                printPreFinish(currentSnail);
            }else if(currentSnail.getDistance() > 100 && currentSnail.getDistance() < 101){
                printOnFinishLine();
            }else{
                printAfterFinishLine();
            }
            System.out.println();
        }
    }

    private static void printPreFinish(Snail currentSnail){
            printSpaces(Math.ceil(currentSnail.getDistance()));
            System.out.print(snailSymbol);
            printFinishLine(currentSnail);
            printSnailId(currentSnail);

    }

    private static void printSpaces(double spaces){
        for(int i = 0; i < spaces; i++){
            System.out.print(" ");
        }
    }

    private static void printSpaces(int spaces){
        for(int i = 0; i < spaces; i++){
            System.out.print(" ");
        }
    }

    private static void printFinishLine(Snail currentSnail){
        printSpaces(100 - Math.ceil(currentSnail.getDistance()));
        System.out.print("|");
    }

    private static void printOnFinishLine() {
        printSpaces(101);
        System.out.print(snailSymbol);
    }

    private static void printAfterFinishLine(){
        printSpaces(101);
        System.out.print("|");
        printSpaces(5);
        System.out.print(snailSymbol);
    }

    public static void clearConsole(int lines){
        for(int i = 0; i < lines; i++){
            System.out.println();
        }
    }

    private static void printSnailId(Snail currentSnail){
        printSpaces(10);
        System.out.print((currentSnail.getId() + 1));
    }

    public static void printSnailRanks(){
        for(Snail currentSnail : Db.getSnails()){
            System.out.println(currentSnail.getName() + " is rank " + currentSnail.getRank() + "/" + Db.getSnails().size());
        }
    }

    public static void printGamblers(){
        for(Gambler currentGambler : Db.getActiveGamblers()){
            System.out.println(currentGambler.getName() + "'s current account balance is: " + currentGambler.getBankBalance());
        }
    }
}