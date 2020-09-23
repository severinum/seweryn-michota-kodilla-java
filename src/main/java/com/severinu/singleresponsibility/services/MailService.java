package com.severinu.singleresponsibility.services;

import com.severinu.singleresponsibility.User;

public class MailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Sending email to " + user.getFullName());
    }
}
