package com.codegym.customer_province_management.service;

import com.codegym.customer_province_management.model.Customer;
import com.codegym.customer_province_management.model.Province;

public interface ICustomerService extends IGenerateService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);
}
