package com.kodilla.good.patterns.challenges.processors;

import com.kodilla.good.patterns.challenges.dto.PurchaseDto;
import com.kodilla.good.patterns.challenges.repository.PurchaseRepository;
import com.kodilla.good.patterns.challenges.request.PurchaseRequest;
import com.kodilla.good.patterns.challenges.services.InformationService;
import com.kodilla.good.patterns.challenges.services.message.BasicMessage;
import com.kodilla.good.patterns.challenges.services.PurchaseService;

public class PurchaseProcessor {

    private InformationService informationService;
    private PurchaseService purchaseService;
    private PurchaseRepository purchaseRepository;

    public PurchaseProcessor(InformationService informationService, PurchaseService purchaseService, PurchaseRepository purchaseRepository) {
        this.informationService = informationService;
        this.purchaseRepository = purchaseRepository;
        this.purchaseService = purchaseService;
    }

    public PurchaseDto process(final PurchaseRequest purchaseRequest) {
        boolean isPurchased = purchaseService.purchase(purchaseRequest.getCustomerDto(),
                                                        purchaseRequest.getProductDto(),
                                                        1);
        if(isPurchased){
            BasicMessage message = new BasicMessage("Dear Customer. You have just made new purchse.");
            informationService.inform(purchaseRequest.getCustomerDto(), message );
            purchaseRepository.createPurchase(purchaseRequest.getCustomerDto(), purchaseRequest.getProductDto(), purchaseRequest.getQuantity() );
            return new PurchaseDto(purchaseRequest.getCustomerDto(), purchaseRequest.getProductDto(), purchaseRequest.getQuantity(), true);
        } else {
            return new PurchaseDto(purchaseRequest.getCustomerDto(), purchaseRequest.getProductDto(), purchaseRequest.getQuantity(), false);
        }
    }
}
