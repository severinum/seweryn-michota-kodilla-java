package com.severinu.singleresponsibility.requests;

import com.severinu.singleresponsibility.User;

import java.time.LocalDateTime;

public class RentRequestRetriever {

    public RentRequest retrieve(){
        User user = new User("John", "Doe");

        LocalDateTime rentFrom = LocalDateTime.of(2020,9,1,12,0);
        LocalDateTime rentTo = LocalDateTime.of(2020,9,10,12,0);

        return new RentRequest(user, rentFrom, rentTo);
    }

}
