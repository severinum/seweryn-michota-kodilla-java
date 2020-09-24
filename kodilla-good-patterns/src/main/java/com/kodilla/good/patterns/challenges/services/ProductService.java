package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.domain.Customer;
import com.kodilla.good.patterns.challenges.domain.Product;
import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.dto.ProductDto;
import com.kodilla.good.patterns.challenges.resources.CustomerResource;
import com.kodilla.good.patterns.challenges.resources.ProductResource;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private ProductResource productResource;

    public ProductService(ProductResource productResource) {
        this.productResource = productResource;
    }

    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = new ArrayList<>();
        List<Product> productsEntities = productResource.getAllProducts();
        if(productsEntities == null){
            return null;
        }
        for(Product product: productsEntities){
            ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getPrice());
            products.add(productDto);
        }
        return products;
    }

    public ProductDto getProductById(int id) {
        Product product = productResource.getProductById(id);
        ProductDto productDto = null;
        if(product != null){
            productDto = new ProductDto(product.getId(), product.getName(), product.getPrice());
        }
        return productDto;
    }
}
