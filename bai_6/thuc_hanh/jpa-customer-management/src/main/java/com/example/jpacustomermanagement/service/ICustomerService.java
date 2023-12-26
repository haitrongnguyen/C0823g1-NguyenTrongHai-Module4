package com.example.jpacustomermanagement.service;

import com.example.jpacustomermanagement.model.Customer;

import java.util.List;

public interface ICustomerService extends IGenerateService<Customer>{
    List<Customer> findAll();

    void save(Customer customer);
}
