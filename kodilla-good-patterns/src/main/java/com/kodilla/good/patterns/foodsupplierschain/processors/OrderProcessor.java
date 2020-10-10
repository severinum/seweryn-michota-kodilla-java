package com.kodilla.good.patterns.foodsupplierschain.processors;

import com.kodilla.good.patterns.foodsupplierschain.domain.Order;
import com.kodilla.good.patterns.foodsupplierschain.domain.OrderItem;
import com.kodilla.good.patterns.foodsupplierschain.resources.SupplierResource;
import com.kodilla.good.patterns.foodsupplierschain.services.SupplierService;
import com.kodilla.good.patterns.foodsupplierschain.suppliers.ISupplier;
import java.util.List;
import java.util.Optional;

public class OrderProcessor {

    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public void process(){
        SupplierService supplierService = new SupplierService(new SupplierResource());
        List<OrderItem> orderItems = order.getOrderItems();

        orderItems.stream().forEach(oi -> {
            supplierService.getSupplierById(oi.getProduct().getSupplierId())
                    .ifPresent(supplier -> supplier.process(oi));
        });

        for(OrderItem oi: orderItems){
           Optional<ISupplier> supplier = supplierService.getSupplierById(oi.getProduct().getSupplierId());
        }
    }
}
