package model.repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static List<Employee> employeeList = new ArrayList<>();
    BaseRepository baseRepository       =new BaseRepository();
    final String SELECT_ALL_EMPLOYEE    = "SELECT * FROM employee;";
    final String INSERT_INTO_EMPLOYEE   = "INSERT INTO customer(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,employee_userName)" +
            " values(?,?,?,?,?,?,?,?);";
    final String SELECT_BY_ID           = "SELECT * FROM employee WHERE employee_id =?;";
    final String SELECT_BY_NAME         = "SELECT * FROM employee WHERE employee_name LIKE ?;";
    final String DELETE_BY_ID           = "DELETE FROM employee WHERE employee_id =?;";
    final String EDIT_BY_ID             = "UPDATE employee set employee_name= ?, employee_birthday= ?,employee_id_card = ?,employee_salary = ?,employee_phone = ?,employee_email = ?,employee_address = ?,employee_userName= ? WHERE employee_id= ?";


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id          = resultSet.getInt("employee_id");
                String name     = resultSet.getString("employee_name");
                String date     = String.valueOf(resultSet.getDate("employee_birthday"));
                String idCard   = resultSet.getString("employee_id_card");
                Double salary   = resultSet.getDouble("employee_salary");
                String phone    = resultSet.getString("employee_phone");
                String email    = resultSet.getString("employee_email");
                String address  = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, date, idCard, salary, phone, email, address, position_id, education_degree_id, division_id, username);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name     = resultSet.getString("employee_name");
                String date     = String.valueOf(resultSet.getDate("employee_birthday"));
                String idCard   = resultSet.getString("employee_id_card");
                Double salary   = resultSet.getDouble("employee_salary");
                String phone    = resultSet.getString("employee_phone");
                String email    = resultSet.getString("employee_email");
                String address  = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, date, idCard, salary, phone, email, address, position_id, education_degree_id, division_id, username);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean save(Employee employee) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);

            preparedStatement.setString (1, employee.getName());
            preparedStatement.setDate   (2, Date.valueOf(employee.getBirthday()));
            preparedStatement.setString (3, employee.getIdCard());
            preparedStatement.setDouble (4, employee.getSalary());
            preparedStatement.setString (5, employee.getPhone());
            preparedStatement.setString (6, employee.getEmail());
            preparedStatement.setString (7, employee.getAddress());
//            preparedStatement.setInt    (9, employee.getPosition_id());
//            preparedStatement.setInt    (10, employee.getEducation_degree_id());
//            preparedStatement.setInt    (11, employee.getDivision_id());
            preparedStatement.setString (8, employee.getUserName());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean update(Employee employee) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BY_ID);

            preparedStatement.setString (1, employee.getName());
            preparedStatement.setDate   (2, Date.valueOf(employee.getBirthday()));
            preparedStatement.setString (3, employee.getIdCard());
            preparedStatement.setDouble (4, employee.getSalary());
            preparedStatement.setString (5, employee.getPhone());
            preparedStatement.setString (6, employee.getEmail());
            preparedStatement.setString (7, employee.getAddress());
            preparedStatement.setString (8, employee.getUserName());
            preparedStatement.setInt    (9, employee.getId());

            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int id          = resultSet.getInt("employee_id");
                String name1    = resultSet.getString("employee_name");
                String date     = String.valueOf(resultSet.getDate("employee_birthday"));
                String idCard   = resultSet.getString("employee_id_card");
                Double salary   = resultSet.getDouble("employee_salary");
                String phone    = resultSet.getString("employee_phone");
                String email    = resultSet.getString("employee_email");
                String address  = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name1, date, idCard, salary, phone, email, address, position_id, education_degree_id, division_id, username);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> search(String name, String email, int position) {
        return null;
    }
}
