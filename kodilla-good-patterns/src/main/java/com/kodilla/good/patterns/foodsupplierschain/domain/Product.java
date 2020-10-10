package com.kodilla.good.patterns.foodsupplierschain.domain;

import java.util.UUID;

public class Product implements IProduct {

    private String id;
    private String name;
    private double price;
    private String supplierId;

    public Product(String name, double price, String supplierId) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.supplierId = supplierId;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getSupplierId() {
        return this.supplierId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }
}
