package com.kodilla.good.patterns.challenges.request;

import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;

public class PurchaseRequest {

    private CustomerDto customerDto;
    private ProductDto productDto;
    private int quantity;

    public PurchaseRequest(CustomerDto customerDto, ProductDto productDto, int quantity) {
        this.customerDto = customerDto;
        this.productDto = productDto;
        this.quantity = quantity;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public int getQuantity() {
        return quantity;
    }
}
