package com.example.customers.repository;

import com.example.customers.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
