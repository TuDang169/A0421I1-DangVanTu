package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.util.List;

public class CustomerServiceImp implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }

    @Override
    public List<Customer> search(String name, boolean gender) {
        return customerRepository.search(name, gender);
    }
}
