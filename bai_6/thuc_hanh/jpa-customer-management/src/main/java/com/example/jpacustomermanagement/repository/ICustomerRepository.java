package com.example.jpacustomermanagement.repository;

import com.example.jpacustomermanagement.model.Customer;

import java.util.List;

public interface ICustomerRepository extends IGenerateRepository<Customer>{
    List<Customer> findAll();
}
