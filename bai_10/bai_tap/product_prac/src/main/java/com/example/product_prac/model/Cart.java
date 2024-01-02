package com.example.product_prac.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart() {
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
    public boolean checkItem(Product product){
        for(Map.Entry<Product,Integer> entry : products.entrySet()){
            if (entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }
    public Map.Entry<Product,Integer> selectItem(Product product){
        for (Map.Entry<Product,Integer> entry: products.entrySet()){
            if (entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
    public void addProduct(Product product){
        if (!checkItem(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> entry = selectItem(product);
            Integer quantity = entry.getValue()+1;
            products.replace(entry.getKey(),quantity);
        }
    }
    public void decrease(Product product){
            Map.Entry<Product,Integer> entry = selectItem(product);
            Integer quantity = entry.getValue()-1;
            products.replace(entry.getKey(),quantity);
    }
    public void increase(Product product){
        Map.Entry<Product,Integer> entry = selectItem(product);
        Integer quantity = entry.getValue()+1;
        products.replace(entry.getKey(),quantity);
    }
}
