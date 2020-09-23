package com.severinu.singleresponsibility.repositories;

import com.severinu.singleresponsibility.User;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository {

    @Override
    public void createRental(User user, LocalDateTime from, LocalDateTime to) {
        System.out.println("Saving rental to DB ...");
    }
}
