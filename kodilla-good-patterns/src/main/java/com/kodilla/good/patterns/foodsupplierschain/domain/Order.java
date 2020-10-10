package com.kodilla.good.patterns.foodsupplierschain.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addProduct(IProduct product, int qty) {
        OrderItem orderItem = new OrderItem(product, qty);
        if(orderItems.size() == 0){
            orderItems.add(orderItem);
        } else {
            if(findProductById(product.getId()).isEmpty()){
                orderItems.add(orderItem);
            } else {
                orderItems.stream()
                        .filter( item -> item.getProduct().getId().equals(product.getId()))
                        .forEach(oi -> oi.setQty(oi.getQty() + qty));
            }
        }
    }

    public Optional<OrderItem> findProductById(String productId){
        return orderItems.stream()
                .filter( orderItem -> orderItem.getProduct().getId().equals(productId))
                .findAny();
    }

    public void printOrderItems(){
        System.out.println("ORDER ITEMS: ");
        orderItems.stream()
                .forEach(oi -> {
                    System.out.println(oi.getProduct().getName() + ", qty: " + oi.getQty());
                });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
