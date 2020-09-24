package com.kodilla.good.patterns.challenges.resources;

import com.kodilla.good.patterns.challenges.domain.Customer;
import com.kodilla.good.patterns.challenges.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductResource {

    private List<Product> products = new ArrayList<>();

    public ProductResource() {
        Product product1 = new Product(1, "Milk", 1.99);
        Product product2 = new Product(2, "Bread", 1.50);
        Product product3 = new Product(3, "Butter", 1.99);
        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id){
        Product product = null;
        for(Product p: products){
            if(p.getId() == id){
                product = p;
            }
        }
        return product;
    }
}
