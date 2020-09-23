package com.severinu.singleresponsibility;

import com.severinu.singleresponsibility.dto.RentalDto;
import com.severinu.singleresponsibility.repositories.CarRentalRepository;
import com.severinu.singleresponsibility.requests.RentRequest;
import com.severinu.singleresponsibility.requests.RentRequestRetriever;
import com.severinu.singleresponsibility.services.CarRentalService;
import com.severinu.singleresponsibility.services.MailService;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();

        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new CarRentalService(), new CarRentalRepository());
        RentalDto process = rentalProcessor.process(rentRequest);

        System.out.println("Rent request for : " + process.getUser().getFullName());
        System.out.println("Rent status : " + process.isRented());
    }
}
