package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.services.message.BasicMessage;

public interface InformationService {
    void inform(CustomerDto customerDto, BasicMessage message);
}
