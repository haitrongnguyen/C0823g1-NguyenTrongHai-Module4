package com.codegym.customer_province_management.repository;

import com.codegym.customer_province_management.model.Customer;
import com.codegym.customer_province_management.model.Province;
import org.springframework.data.repository.CrudRepository;


public interface ICustomerRepository extends CrudRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
