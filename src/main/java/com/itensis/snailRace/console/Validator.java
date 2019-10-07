package com.itensis.snailRace.console;

import com.itensis.snailRace.Data.Messages;

import java.util.List;

class Validator {

   boolean validateIntInRange(int min, int max, int userInput){
      if(userInput > min && userInput < max){
         return true;
      }
      Printer.printMessage(Messages.ERROR_NOT_CORRECT);
      return  false;
   }

   boolean validateLongInRange(long min, long max, long userInput){
       if(userInput > min && userInput < max){
           return true;
       }
       Printer.printMessage(Messages.ERROR_NOT_CORRECT);
       return  false;
   }

   boolean isInt(String userInput){
      try {
         int userInputInt = Integer.parseInt(userInput);
      }catch (Exception e){
         Printer.printMessage(Messages.ERROR_NOT_CORRECT);
         return false;
      }
      return true;
   }

   boolean isLong(String userInput){
       try{
           long userInputLong = Long.parseLong(userInput);
       }catch (Exception e){
           Printer.printMessage(Messages.ERROR_NOT_CORRECT);
           return false;
       }
       return true;
   }

   boolean isYesOrNo(String userInput){
       if(userInput.equals("y") || userInput.equals("n")){
           return true;
       }
       Printer.printMessage(Messages.ERROR_NOT_CORRECT);
       return false;
   }

   boolean validateIntInList(int input, List<Integer> intList){
       if(intList.contains(input)){
           return true;
       }
       Printer.printMessage(Messages.ERROR_NOT_CORRECT);
       return false;
   }
}
