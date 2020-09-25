package com.kodilla.good.patterns.foodsupplierschain.suppliers;

import com.kodilla.good.patterns.foodsupplierschain.domain.OrderItem;

public class OrganicMushroomsLtd implements ISupplier {

    @Override
    public String getName() {
        return "Organic Mushrooms Ltd";
    }

    @Override
    public String getId() {
        return "SUPORGMUS";
    }

    @Override
    public void process(OrderItem orderItem) {
        System.out.println("Processing order for by " + getName() + " supplier");
        System.out.println("\tAdding 5% discount for all " + getName() + " orders");
        orderItem.setPrice( orderItem.getProduct().getPrice() * 0.95);
        System.out.println("\tOrdering : " + orderItem.getProduct().getName() +  " x " + orderItem.getQty() ) ;

    }
}
