package model.repository;

import model.bean.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(int id);
    boolean save(Employee employee);
    boolean delete(int id);
    boolean update(Employee employee);
    List<Employee> searchByName(String name);
    List<Employee> search(String name, String email, int position);
}
