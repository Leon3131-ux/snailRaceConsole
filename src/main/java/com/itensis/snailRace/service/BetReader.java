package com.itensis.snailRace.service;

import com.itensis.snailRace.Data.*;
import com.itensis.snailRace.console.Printer;
import com.itensis.snailRace.console.UserInput;
import com.itensis.snailRace.db.Db;

public class BetReader { //TODO ÜBERARBEITEN

    private UserInput userInput;

    public BetReader(UserInput userInput) {
        this.userInput = userInput;
    }

    void requestBets(){
        for(Gambler currentGambler : Db.getActiveGamblers()) {
            do {
                int snailId = askSnailId(currentGambler);
                long betAmount = askBetAmount(currentGambler);
                int rank = askRank();
                createBet(currentGambler, Db.getSnail(snailId), betAmount, rank);
                currentGambler.setBankBalance(currentGambler.getBankBalance() - betAmount);
            } while (userInput.askYes(Messages.ENTER_MORE_BETS));
        }
    }

    private void createBet(Gambler currentGambler, Snail snail, long betAmount, int rank) {
        Bet bet = new Bet(currentGambler, snail, betAmount, rank);
        Db.getBettingOffice().saveBet(bet);
    }

    private long askBetAmount(Gambler currentGambler) {
        Printer.printMessage(currentGambler.getBankBalance(), Messages.ENTER_BET);
        return userInput.askLongInRange(-1, currentGambler.getBankBalance() + 1, Messages.EMPTY);
    }

    private int askSnailId(Gambler currentGambler) {
        Printer.printMessage(currentGambler.getName(), Messages.CHOOSE_FROM_SNAILS);
        Printer.clearConsole(1);
        Printer.printSnails();
        Printer.clearConsole(1);
        return userInput.askIntInList(Db.getSnailIds(), Messages.ENTER_SNAIL, 1);
    }

    private int askRank(){
        return userInput.askIntInRange(0, Db.getSnails().size() + 1, Messages.ENTER_RANK);
    }
}
