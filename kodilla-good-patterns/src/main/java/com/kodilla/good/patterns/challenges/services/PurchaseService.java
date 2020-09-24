package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;

public interface PurchaseService {
    boolean purchase(CustomerDto customerDto, ProductDto productDto, int qty);
}
