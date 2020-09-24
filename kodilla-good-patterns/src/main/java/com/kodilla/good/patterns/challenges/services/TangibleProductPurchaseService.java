package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;

public class TangibleProductPurchaseService implements PurchaseService {

    @Override
    public boolean purchase(CustomerDto customerDto, ProductDto productDto, int qty) {
        if(customerDto != null && productDto != null  && qty > 0){
            System.out.println("Purchase of " + qty + " x " + productDto.getName() +
                    " for " + customerDto.getFname() + " " + customerDto.getLname() +
                    " approved. ");
            return true;
        }
        return false;
    }
}
