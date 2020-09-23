package com.severinu.singleresponsibility.services;

import com.severinu.singleresponsibility.User;

import java.time.LocalDateTime;

public interface RentalService {

    boolean rent(User user, LocalDateTime from, LocalDateTime to);

}
