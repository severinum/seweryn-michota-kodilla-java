package com.kodilla.exception.moje_testy.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberReaderTest {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    private static int divide(){
        int x = getInt();
        int y = getInt();
        System.out.println("x = " + x + " , y = " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer : ");
        while (true){
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Please ener number using only digits 0 to 9");
            }
        }
    }
}
