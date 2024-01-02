package com.example.customerprovince.service.impl;

import com.example.customerprovince.model.Customer;
import com.example.customerprovince.repository.ICustomerRepository;
import com.example.customerprovince.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(this.findById(id));
    }
}
