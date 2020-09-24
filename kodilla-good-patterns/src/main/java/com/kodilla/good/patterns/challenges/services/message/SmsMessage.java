package com.kodilla.good.patterns.challenges.services.message;

public class SmsMessage extends BasicMessage implements Message {

    public SmsMessage(String message) {
        super(message);
        setMessage("SMS message : " + message);
    }

    @Override
    public void send() {
        System.out.println("SENDING SMS MESSAGE ..." + getMessage());
    }
}
