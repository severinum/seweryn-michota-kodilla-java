package com.kodilla.good.patterns.foodsupplierschain.domain;

public interface IProduct {
    String getId();
    String getName();
    double getPrice();
    void setPrice(double price);
    String getSupplierId();
}
