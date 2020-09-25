package com.kodilla.good.patterns.foodsupplierschain.services;

import com.kodilla.good.patterns.foodsupplierschain.resources.SupplierResource;
import com.kodilla.good.patterns.foodsupplierschain.suppliers.ISupplier;

import java.util.Optional;

public class SupplierService {

    SupplierResource supplierResource;

    public SupplierService(SupplierResource supplierResource) {
        this.supplierResource = supplierResource;
    }

    public Optional<ISupplier> getSupplierById(String supplierId){
        return supplierResource.getOneById(supplierId);
    }

    public void add(ISupplier supplier){
        supplierResource.add(supplier);
    }

}