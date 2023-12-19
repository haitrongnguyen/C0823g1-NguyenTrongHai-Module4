package com.example.customers.service;

import com.example.customers.model.Customer;
import com.example.customers.repository.CustomerRepository;
import com.example.customers.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
