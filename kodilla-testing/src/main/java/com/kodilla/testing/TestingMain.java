package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // calculator test
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;

        int additionResult = calculator.add(a, b);
        int subtractionResult = calculator.subtract(a, b);

        if(additionResult == 15) {
            System.out.println("Addition test : OK");
        } else {
            System.out.println("Addition test:  Fail !");
        }
        if(subtractionResult == 5){
            System.out.println("Subtraction result : OK");
        } else {
            System.out.println("Subtraction result : Fail !");
        }

    }
}
