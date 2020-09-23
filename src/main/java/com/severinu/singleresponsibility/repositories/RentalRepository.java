package com.severinu.singleresponsibility.repositories;

import com.severinu.singleresponsibility.User;

import java.time.LocalDateTime;

public interface RentalRepository {
    void createRental(User user, LocalDateTime from, LocalDateTime to);
}
