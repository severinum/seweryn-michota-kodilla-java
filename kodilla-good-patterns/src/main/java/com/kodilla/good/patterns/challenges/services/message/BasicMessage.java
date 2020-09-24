package com.kodilla.good.patterns.challenges.services.message;

public class BasicMessage {

    private String message;

    public BasicMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}