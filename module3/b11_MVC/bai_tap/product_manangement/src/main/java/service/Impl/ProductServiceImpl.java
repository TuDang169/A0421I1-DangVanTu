package service.Impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "TV",        2000, "Easily Broken"));
        products.put(2, new Product(2, "Fridge",    5000, "Heavy"));
        products.put(3, new Product(3, "Microwave", 1000, "Read Menu First"));
        products.put(4, new Product(4, "Iron",      300,  "Heavy"));
        products.put(5, new Product(5, "Stove",     500,  "Read Menu First"));
        products.put(6, new Product(6, "Sofa",      3000, "Heavy"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
