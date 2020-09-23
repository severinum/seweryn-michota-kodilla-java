package com.severinu.singleresponsibility.services;

import com.severinu.singleresponsibility.User;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {

    public boolean rent(User user, LocalDateTime rentFrom, LocalDateTime rentTo) {
        System.out.println("Processing car rent request .... returning status");
        return true;
    }
}
