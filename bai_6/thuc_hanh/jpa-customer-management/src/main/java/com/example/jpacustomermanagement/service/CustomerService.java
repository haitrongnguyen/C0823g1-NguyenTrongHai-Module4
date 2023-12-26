package com.example.jpacustomermanagement.service;

import com.example.jpacustomermanagement.model.Customer;
import com.example.jpacustomermanagement.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
