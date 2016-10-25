package ua.validator.core;

import java.util.Scanner;

public class Validator {

    private final int COUNTRY_CODE_NUMBER_LENGTH = 13;
    private final int NUMBER_LENGTH = 10;
    private boolean isLengthValidate;
    private char [] digitSymbols;

    public static void main(String[] args) {
        new Validator();
    }
    public Validator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the phone number:");
        String inputValue = scanner.next();

        while(!validation(inputValue)){

            System.out.println("Phone number is incorrect. Please enter the phone number:");
            inputValue = scanner.next();

        }
        int sum = calculation();
        reduceSum(sum);
    }
    private boolean validation(String number){
        if(isCodeValidate(number) && isWithoutLetters(number) && isLengthValidate){
            return true;
        }
        return false;
    }
    
    private int calculation(){
        int startI = (digitSymbols.length==13) ? 1:0;
        int [] values = new int[digitSymbols.length];
        int sum = 0;
        for (int i = startI; i < digitSymbols.length; i++) {
            values[i] = Character.getNumericValue(digitSymbols[i]);
            sum+=values[i];
        }
        return sum;
    }
    private void reduceSum(int sum){
        int round = 1;
        if(sum<10){
            printResult(sum);
        }else{
            System.out.println(round+"st round of calculation, sum equals: " + sum);
            while(sum>=10){
                sum = (sum % 10) + (sum/10);
                round++;
                System.out.println(round+"st round of calculation, sum equals: " + sum);
            }
            printResult(sum);
        }
    } 
    private void printResult(int result){
        String digitsValues[] = {"Zero","One","Two","Three","Four"};
        String message = "Final result is: "+((result<5)?digitsValues[result]:result);
        System.out.println(message);
    }
    
    private boolean isWithoutLetters(String number){
        digitSymbols = number.toCharArray();
        int startI = (number.length()==13) ? 1:0;
        for (int i = startI; i < digitSymbols.length; i++) {
            if(!Character.isDigit(digitSymbols[i])){
                return false;
            }
        }
        return true;
    }
    private boolean isCodeValidate(String number) {
        if (number.startsWith("+380")) {
            isLengthValidate = (number.length()==COUNTRY_CODE_NUMBER_LENGTH) ? true : false;
            return true;
        } else if (number.startsWith("09")) {
            isLengthValidate = (number.length()==NUMBER_LENGTH) ? true : false;
            return true;
        }
        return false;
    }
}
