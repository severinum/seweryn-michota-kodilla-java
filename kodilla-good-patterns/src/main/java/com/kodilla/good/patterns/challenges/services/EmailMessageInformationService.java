package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.services.message.BasicMessage;
import com.kodilla.good.patterns.challenges.services.message.EmailMessage;

public class EmailMessageInformationService implements InformationService {

    @Override
    public void inform(CustomerDto customerDto, BasicMessage message) {
        EmailMessage emailMessage = new EmailMessage("Hi " + customerDto.getFname() +"! Your order has been placed");
        emailMessage.send();
    }
}
