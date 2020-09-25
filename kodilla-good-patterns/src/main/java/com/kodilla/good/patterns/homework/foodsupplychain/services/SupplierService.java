package com.kodilla.good.patterns.homework.foodsupplychain.services;

import com.kodilla.good.patterns.homework.foodsupplychain.dtos.SupplierDto;
import java.util.ArrayList;
import java.util.List;


public class SupplierService {

    public List<SupplierDto> getAllSuppliers(){
        List<SupplierDto> suppliers = new ArrayList<>();

        return suppliers;
    }

    public SupplierDto getSupplier(int id){
        return new SupplierDto();
    }

}
