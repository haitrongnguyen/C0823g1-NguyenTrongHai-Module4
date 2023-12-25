package com.example.ormproductmanagement.service;

import com.example.ormproductmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);
    Product findById(int id);

    void remove(int id);

    List<Product> findByName(String name);

    List<Product> sort();

    List<Product> sortByName();
}
