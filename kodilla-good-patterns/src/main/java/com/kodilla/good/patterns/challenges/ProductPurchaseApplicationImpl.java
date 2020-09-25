package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.dto.PurchaseDto;
import com.kodilla.good.patterns.challenges.processors.PurchaseProcessor;
import com.kodilla.good.patterns.challenges.repository.TangibleProductPurchaseRepository;
import com.kodilla.good.patterns.challenges.request.PurchaseRequest;
import com.kodilla.good.patterns.challenges.request.PurchaseRequestRetriever;
import com.kodilla.good.patterns.challenges.resources.CustomerResource;
import com.kodilla.good.patterns.challenges.resources.ProductResource;
import com.kodilla.good.patterns.challenges.services.CustomerService;
import com.kodilla.good.patterns.challenges.services.EmailMessageInformationService;
import com.kodilla.good.patterns.challenges.services.ProductService;
import com.kodilla.good.patterns.challenges.services.TangibleProductPurchaseService;

public class ProductPurchaseApplicationImpl {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService(new CustomerResource());
        ProductService productService = new ProductService(new ProductResource());

        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve(customerService, productService);

        PurchaseProcessor purchaseProcessor = new PurchaseProcessor(new EmailMessageInformationService(), new TangibleProductPurchaseService(), new TangibleProductPurchaseRepository());
        PurchaseDto purchaseDto = purchaseProcessor.process(purchaseRequest);

        System.out.println(purchaseDto);

    }
}
