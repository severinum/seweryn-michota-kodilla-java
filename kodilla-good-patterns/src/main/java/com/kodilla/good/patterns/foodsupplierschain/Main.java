package com.kodilla.good.patterns.foodsupplierschain;

import com.kodilla.good.patterns.foodsupplierschain.domain.IProduct;
import com.kodilla.good.patterns.foodsupplierschain.domain.Order;
import com.kodilla.good.patterns.foodsupplierschain.domain.Product;
import com.kodilla.good.patterns.foodsupplierschain.processors.OrderProcessor;
import com.kodilla.good.patterns.foodsupplierschain.resources.ProductResource;
import com.kodilla.good.patterns.foodsupplierschain.resources.SupplierResource;
import com.kodilla.good.patterns.foodsupplierschain.services.ProductService;
import com.kodilla.good.patterns.foodsupplierschain.services.SupplierService;
import com.kodilla.good.patterns.foodsupplierschain.suppliers.DrySockSupplierLimited;
import com.kodilla.good.patterns.foodsupplierschain.suppliers.ISupplier;
import com.kodilla.good.patterns.foodsupplierschain.suppliers.OrganicMushroomsLtd;

public class Main {

    public static void main(String[] args) {

        ProductService productService = new ProductService(new ProductResource());
        SupplierService supplierService = new SupplierService(new SupplierResource());

        /* new supplier */
        ISupplier supplierOrganicMushrooms = new OrganicMushroomsLtd();
        String supplierOrganicMushroomsId= supplierOrganicMushrooms.getId();

        IProduct product1 = new Product("Porcini 100g", 4.99, supplierOrganicMushroomsId);
        IProduct product2 = new Product("Button Mushrooms 500g", 2.99, supplierOrganicMushroomsId);

        productService.add(product1);
        productService.add(product2);

        supplierService.add(supplierOrganicMushrooms);

        /* new supplier */
        ISupplier dryStockSupplier = new DrySockSupplierLimited();
        String dryStockSupplierId = dryStockSupplier.getId();

        IProduct product3 = new Product("Bianko Farinha 500g", 7.99, dryStockSupplierId);
        IProduct product4 = new Product("Button Mushrooms 500g", 2.99, dryStockSupplierId);

        productService.add(product3);
        productService.add(product4);

        supplierService.add(dryStockSupplier);

        /* create order */
        Order order = new Order();
        order.addProduct(product1, 1);
        order.addProduct(product1, 5);
        order.addProduct(product3, 3);

        order.printOrderItems();

        OrderProcessor orderProcessor = new OrderProcessor(order);
        orderProcessor.process();

    }
}
