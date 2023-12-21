package com.example.customersmanagementthymeleaf.repository;

import com.example.customersmanagementthymeleaf.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();

    void saveCustomer(Customer customer);

    Customer findCustomerById(int id);

    void updateCustomer(Customer customer);

    void removeCustomer(Customer customer);
}
