package com.kodilla.good.patterns.challenges.request;

import com.kodilla.good.patterns.challenges.domain.Product;
import com.kodilla.good.patterns.challenges.domain.Customer;
import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;
import com.kodilla.good.patterns.challenges.services.CustomerService;
import com.kodilla.good.patterns.challenges.services.ProductService;

public class PurchaseRequestRetriever {

    private CustomerService customerService;
    private ProductService productService;

    public PurchaseRequest retrieve(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;

        CustomerDto customerDto = customerService.getCustomerById(1);
        ProductDto productDto = productService.getProductById(1);

        return new PurchaseRequest(customerDto, productDto, 1);
    }
}
