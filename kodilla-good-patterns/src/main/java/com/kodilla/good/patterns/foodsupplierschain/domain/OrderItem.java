package com.kodilla.good.patterns.foodsupplierschain.domain;

public class OrderItem {

    private IProduct product;
    private int qty;

    public OrderItem(IProduct product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public IProduct getProduct() {
        return product;
    }

    public void setProduct(IProduct product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price){
        this.product.setPrice(price);
    }

}
