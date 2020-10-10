package com.kodilla.good.patterns.foodsupplierschain.suppliers;

import com.kodilla.good.patterns.foodsupplierschain.domain.Order;
import com.kodilla.good.patterns.foodsupplierschain.domain.OrderItem;

public interface ISupplier {
    String getName();
    String getId();
    void process(OrderItem orderItem);
}
