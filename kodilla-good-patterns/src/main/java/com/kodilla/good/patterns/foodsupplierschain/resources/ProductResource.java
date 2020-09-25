package com.kodilla.good.patterns.foodsupplierschain.resources;

import com.kodilla.good.patterns.foodsupplierschain.domain.IProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductResource {

    private static List<IProduct> products = new ArrayList<>();

    public Optional<IProduct> getOneById(String productId){
        if(products.size() == 0){
            return Optional.empty();
        }
        return products.stream()
                .filter( product -> product.getId().equals(productId))
                .findAny();
    }

    public void add(IProduct product) {
        Optional<IProduct> haveProduct = getOneById(product.getId());
        if(haveProduct.isEmpty()){
            products.add(product);

        } else {
            System.out.println("Can't add this product. Product with this ID already exist.");
        }
    }
}
