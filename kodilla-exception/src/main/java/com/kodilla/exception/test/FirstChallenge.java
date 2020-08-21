package com.kodilla.exception.test;

import java.nio.file.Path;

public class FirstChallenge {

    public double divide(double a, double b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println("Division by zero error : " + e);
        } finally {
            System.out.println(a + " / " + b);
        }
        return 0;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(3, 0);
        System.out.println(result);
    }
}
