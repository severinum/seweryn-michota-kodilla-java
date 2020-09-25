package com.kodilla.good.patterns.foodsupplierschain.resources;

import com.kodilla.good.patterns.foodsupplierschain.suppliers.ISupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupplierResource {

    private static List<ISupplier> suppliers = new ArrayList<>();

    public Optional<ISupplier> getOneById(String supplierId){
        if(suppliers.size() == 0){
            return Optional.empty();
        }
        return suppliers.stream()
                .filter( supplier -> supplier.getId().equals(supplierId))
                .findAny();
    }

    public void add(ISupplier supplier){
        Optional<ISupplier> haveSupplier = getOneById(supplier.getId());
        if(haveSupplier.isEmpty()){
            suppliers.add(supplier);
        } else {
            System.out.println("Can't add this supplier. Supplier with this ID already exist.");
        }
    }
}
