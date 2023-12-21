package com.example.productsmanagementthymeleaf.repository;

import com.example.productsmanagementthymeleaf.model.Product;

import java.util.*;

public class ProductRepository implements IProductRepository{
    private static final Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Mì tôm Hảo Hảo",10000,"Mì tôm","Hảo Hảo"));
        productMap.put(2,new Product(2,"Mì tôm Ba Miền",8000,"Mì tôm","Ba Miền"));
        productMap.put(3,new Product(3,"Mì tôm Gấu Đỏ",7000,"Mì tôm","Gấu Đỏ"));
        productMap.put(4,new Product(4,"Mì tôm Lẩu Thái",15000,"Mì tôm","Lẩu Thái"));
        productMap.put(5,new Product(5,"Mì tôm Miliket",10000,"Mì tôm","Miliket"));
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>(productMap.values());
        products.sort(Comparator.comparing(Product::getName));
        return products;
    }

    @Override
    public Product findProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void delete(int id) {
        System.out.println(id);
        productMap.remove(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer,Product> productEntry:productMap.entrySet()){
            if (productEntry.getValue().getName().toLowerCase().contains(name.toLowerCase())){
                products.add(productEntry.getValue());
            }
        }
        return products;
    }
}
