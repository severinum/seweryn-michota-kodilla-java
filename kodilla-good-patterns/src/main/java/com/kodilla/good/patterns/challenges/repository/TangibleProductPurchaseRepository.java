package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;

public class TangibleProductPurchaseRepository implements PurchaseRepository {
    @Override
    public void createPurchase(CustomerDto customerDto, ProductDto productDto, int qty) {
        System.out.println("Saving purchase of tangible product to DB");
    }
}
