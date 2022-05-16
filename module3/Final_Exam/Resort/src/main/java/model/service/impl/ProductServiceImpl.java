package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
