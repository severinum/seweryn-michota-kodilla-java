package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SeconChallenge seconChallenge = new SeconChallenge();
        try {
            String result = seconChallenge.probablyIWillThrowException(3, 1);
        } catch (Exception e) {
            System.out.println("There was an exception in probablyIWillThrowException method | message : " + e);
        } finally {
            System.out.println("I will run if you like it or not");
        }
    }

}
