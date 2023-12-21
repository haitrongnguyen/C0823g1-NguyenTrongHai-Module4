package com.example.productsmanagementthymeleaf.repository;

import com.example.productsmanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    Product findProductById(int id);

    void update(int id, Product product);

    void delete(int id);

    void save(Product product);

    List<Product> findByName(String name);
}
