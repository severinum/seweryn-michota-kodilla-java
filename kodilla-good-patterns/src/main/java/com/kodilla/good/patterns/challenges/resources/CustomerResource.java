package com.kodilla.good.patterns.challenges.resources;

import com.kodilla.good.patterns.challenges.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerResource {

    private List<Customer> customers = new ArrayList<>();

    public CustomerResource() {
        Customer customer1 = new Customer(1, "Adam", "Smith");
        Customer customer2 = new Customer(2, "John", "Doe");
        Customer customer3 = new Customer(3, "Anna", "McAllister");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id){
        Customer customer = null;
        for(Customer c: customers){
            if(c.getId() == id){
                customer = c;
            }
        }
        return customer;
    }
}
