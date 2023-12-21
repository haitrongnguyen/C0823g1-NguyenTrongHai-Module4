package com.example.customersmanagementthymeleaf.repository;

import com.example.customersmanagementthymeleaf.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static final List<Customer> customers;
    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "John", "john@codegym.vn", "Ha Noi"));
        customers.add(new Customer(2, "Bill", "bill@codegym.vn", "Hai Phong"));
        customers.add(new Customer(3, "Alex", "alex@codegym.vn", "Sai Gon"));
        customers.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijing"));
        customers.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.add(new Customer(6, "Rose", "rose@codegym.vn", "NewYork"));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        for (Customer customer:customers){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (Customer customer1:customers){
            if (customer1.getId() == customer.getId()){
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
            }
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        for (Customer c: customers){
            if (c.getId()==customer.getId()){
                customers.remove(c);
                break;
            }
        }
    }
}
