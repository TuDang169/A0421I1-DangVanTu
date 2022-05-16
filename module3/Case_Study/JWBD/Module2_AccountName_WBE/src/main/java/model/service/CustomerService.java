package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    boolean save(Customer customer);
    boolean delete(int id);
    boolean update(Customer customer);
    List<Customer> searchByName(String name);
    List<Customer> search(String name, boolean gender);
}
