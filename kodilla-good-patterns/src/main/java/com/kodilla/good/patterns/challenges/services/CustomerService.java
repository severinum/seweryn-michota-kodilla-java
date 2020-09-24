package com.kodilla.good.patterns.challenges.services;

import com.kodilla.good.patterns.challenges.domain.Customer;
import com.kodilla.good.patterns.challenges.dto.CustomerDto;
import com.kodilla.good.patterns.challenges.resources.CustomerResource;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private CustomerResource customerResource;

    public CustomerService(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    public List<CustomerDto> getAllCustomers() {
        List< CustomerDto> customers = new ArrayList<>();
        List<Customer> customerEntities = customerResource.getAllCustomers();
        if(customerEntities == null){
            return null;
        }
        for(Customer customer: customerEntities ){
            CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getFname(), customer.getLname());
            customers.add(customerDto);
        }
        return customers;
    }

    public CustomerDto getCustomerById(int id) {
        Customer customer = customerResource.getCustomerById(id);
        CustomerDto customerDto = null;
        if(customer !=null){
            customerDto = new CustomerDto(customer.getId(), customer.getFname(), customer.getLname());
        }
        return customerDto;
    }
}
