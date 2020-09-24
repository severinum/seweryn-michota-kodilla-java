package com.kodilla.good.patterns.challenges.services.message;

public class EmailMessage extends BasicMessage implements Message {

    public EmailMessage(String message) {
        super(message);
        this.setMessage("Email message body : " + message);
    }


    @Override
    public void send() {
        System.out.println("SENDING EMAIL MESSAGE ..." + getMessage()) ;
    }
}
