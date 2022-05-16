package model.service.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean save(Employee Employee) {
        return employeeRepository.save(Employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public boolean update(Employee Employee) {
        return employeeRepository.update(Employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }

    @Override
    public List<Employee> search(String name, String email, int position) {
        return employeeRepository.search(name, email, position);
    }
}
