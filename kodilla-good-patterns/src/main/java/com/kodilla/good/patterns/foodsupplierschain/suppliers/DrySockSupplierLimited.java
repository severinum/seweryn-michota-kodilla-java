package com.kodilla.good.patterns.foodsupplierschain.suppliers;

import com.kodilla.good.patterns.foodsupplierschain.domain.Order;
import com.kodilla.good.patterns.foodsupplierschain.domain.OrderItem;

public class DrySockSupplierLimited implements ISupplier {
    @Override
    public String getName() {
        return "Dry Stock Supplier Limited";
    }

    @Override
    public String getId() {
        return "DRYSTOSUPLIM";
    }

    @Override
    public void process(OrderItem orderItem) {
        System.out.println("Processing order for by " + getName() + " supplier");
        System.out.println("\tOrdering : " + orderItem.getProduct().getName() + " x " + orderItem.getQty());
        System.out.println("\tSending email notification to the warehouse");
    }

}
