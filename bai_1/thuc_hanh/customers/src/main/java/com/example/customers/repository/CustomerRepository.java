package com.example.customers.repository;

import com.example.customers.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customers = new ArrayList<>();;
    static {

        customers.add(new Customer(1,"Nguyen Khac Nhat","nhat@gmail.com","Hà Nội"));
        customers.add(new Customer(2,"Dang Huy Hoa","hoa@gmail.com","Đà Nẵng"));
        customers.add(new Customer(3,"Le Thi Chau","chau@gmail.com","Hà Nội"));
        customers.add(new Customer(4,"Nguyen Thuy Duong","duong@gmail.com","Đà Nẵng"));
        customers.add(new Customer(5,"Code Gym","codegym@gmail.com","Hà Nội"));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
