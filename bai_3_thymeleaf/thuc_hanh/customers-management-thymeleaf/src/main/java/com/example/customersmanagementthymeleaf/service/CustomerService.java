package com.example.customersmanagementthymeleaf.service;

import com.example.customersmanagementthymeleaf.model.Customer;
import com.example.customersmanagementthymeleaf.repository.CustomerRepository;
import com.example.customersmanagementthymeleaf.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerRepository.removeCustomer(customer);
    }
}
