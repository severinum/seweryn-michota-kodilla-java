package com.kodilla.good.patterns.challenges.dto;

import com.kodilla.good.patterns.challenges.domain.Customer;

public class PurchaseDto {

    public CustomerDto customerDto;
    public ProductDto productDto;
    public int quantity;
    public boolean isPurchased;

    public PurchaseDto(final CustomerDto customerDto, final ProductDto productDto, final int quantity, final boolean isPurchased) {
        this.customerDto = customerDto;
        this.productDto = productDto;
        this.quantity = quantity;
        this.isPurchased = isPurchased;
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

    public boolean isPurchased() {
        return isPurchased;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "customerDto=" + customerDto +
                ", productDto=" + productDto +
                ", quantity=" + quantity +
                ", isPurchased=" + isPurchased +
                '}';
    }
}
