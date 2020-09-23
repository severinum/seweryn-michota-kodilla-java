package com.severinu.singleresponsibility;

import com.severinu.singleresponsibility.dto.RentalDto;
import com.severinu.singleresponsibility.repositories.RentalRepository;
import com.severinu.singleresponsibility.requests.RentRequest;
import com.severinu.singleresponsibility.services.InformationService;
import com.severinu.singleresponsibility.services.RentalService;

import java.time.LocalDateTime;

public class RentalProcessor {

    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public RentalProcessor(final InformationService informationService,
                           final RentalService rentalService,
                           final RentalRepository rentalRepository ) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest){
        boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
        if(isRented){
            informationService.inform(rentRequest.getUser());
            rentalRepository.createRental(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
            return new RentalDto(rentRequest.getUser(), true);
        } else {
            return new RentalDto(rentRequest.getUser(), false);
        }
    }
}
