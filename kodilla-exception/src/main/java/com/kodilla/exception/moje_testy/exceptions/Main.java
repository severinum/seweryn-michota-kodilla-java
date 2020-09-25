package com.kodilla.exception.moje_testy.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int x = getIntValid();
        System.out.println("x is : " + x);

        int y = getIntExceptionHandler();
        System.out.println("y is : " + y);
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntExceptionHandler(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer value : ");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    private static int getIntValid(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer : ");
        String input = s.next();
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }


    private static int divide(int x , int y){
        if(y != 0){
            return x / y ;
        } else {
            return 0;
        }
    }

    private static int divideTwo(int x , int y){
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divideThree(int x, int y){
        return x / y ;
    }
}
