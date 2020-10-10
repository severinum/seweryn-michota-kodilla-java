package com.kodilla.good.patterns.foodsupplierschain.services;

import com.kodilla.good.patterns.foodsupplierschain.domain.IProduct;
import com.kodilla.good.patterns.foodsupplierschain.resources.ProductResource;

public class ProductService {

    private ProductResource productResource;

    public ProductService(ProductResource productResource) {
        this.productResource = productResource;
    }

    public void add(IProduct product) {
        productResource.add(product);
    }
}
