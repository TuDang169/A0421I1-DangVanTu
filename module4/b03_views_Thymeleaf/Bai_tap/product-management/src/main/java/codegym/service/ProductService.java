package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Watch", 3000, "China"));
        products.put(2, new Product(2, "TV", 2000, "Japan"));
        products.put(3, new Product(3, "Note 9", 10000, "USA"));
        products.put(4, new Product(4, "Iphone 10", 8000, "VN"));
        products.put(5, new Product(5, "Iphone 5", 5500, "England"));
        products.put(6, new Product(6, "Cooker", 1200, "Japan"));
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
