package com.itensis.snailRace.Data;

public enum Messages {
    ERROR_NOT_CORRECT("input is not acceptable"),
    ENTER_NAME("please enter your name"),
    ENTER_MORE_GAMBLERS("are there more gamblers (y/n)"),
    CHOOSE_FROM_SNAILS(", please choose from the following snails (use the snail id)"),
    ENTER_SNAIL("enter snail id"),
    ENTER_BET("please enter your bet amount, you available balance is"),
    ENTER_MORE_BETS("do you want to place more bets? (y/n)"),
    ENTER_RANK("enter the rank that you think the snail is going to be"),
    PLAY_ANOTHER_GAME("do you want to play another game? (y/n)"),
    ENTER_AMOUNT_SNAILS("please enter the amount of snails(1 - 60)"),
    EMPTY("");

    private String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
