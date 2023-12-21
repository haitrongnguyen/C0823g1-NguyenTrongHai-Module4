package com.example.productsmanagementthymeleaf.service;

import com.example.productsmanagementthymeleaf.model.Product;
import com.example.productsmanagementthymeleaf.repository.IProductRepository;
import com.example.productsmanagementthymeleaf.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
