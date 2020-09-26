package com.kodilla.good.patterns.foodsupplierschain.resources;

import com.kodilla.good.patterns.foodsupplierschain.domain.IProduct;
import java.util.*;

public class ProductResource {

    private static Map<String ,IProduct> products = new HashMap<>();

    public void add(IProduct product) {
        products.put(product.getId(), product);
    }
}
