package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.domain.Customer;
import com.kodilla.good.patterns.challenges.domain.Product;
import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;

public interface PurchaseRepository {
    void createPurchase(CustomerDto customerDto, ProductDto productDto, int qty);
}
