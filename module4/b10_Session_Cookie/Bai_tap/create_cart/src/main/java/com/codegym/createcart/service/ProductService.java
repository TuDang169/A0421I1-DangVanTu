package com.codegym.createcart.service;

import com.codegym.createcart.model.Product;

public interface ProductService {

    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product customer);

    void remove(Long id);
}
