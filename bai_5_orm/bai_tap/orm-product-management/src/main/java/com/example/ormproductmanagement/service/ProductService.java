package com.example.ormproductmanagement.service;

import com.example.ormproductmanagement.model.Product;
import com.example.ormproductmanagement.repository.IProductRepository;
import com.example.ormproductmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> sort() {
        return productRepository.sort();
    }

    @Override
    public List<Product> sortByName() {
        return productRepository.sortByName();
    }
}
