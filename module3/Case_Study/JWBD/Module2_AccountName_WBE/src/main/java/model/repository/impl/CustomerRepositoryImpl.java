package model.repository.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    BaseRepository baseRepository       =new BaseRepository();
    final String SELECT_ALL_CUSTOMER    = "SELECT * FROM customer;";
    final String INSERT_INTO_CUSTOMER   = "INSERT INTO customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)" +
                                                                                            " values(?,?,?,?,?,?,?,?);";
    final String SELECT_BY_ID           = "SELECT * FROM customer WHERE customer_id =?;";
    final String SELECT_BY_NAME         = "SELECT * FROM customer WHERE customer_name LIKE ?;";
    final String SELECT_MIX             = "SELECT * FROM customer WHERE customer_name like ? and customer_gender = ?;";
    final String DELETE_BY_ID           = "DELETE FROM customer WHERE customer_id =?;";
    final String EDIT_BY_ID             = "UPDATE customer set customer_type_id= ?, customer_name= ?, customer_birthday= ?,customer_gender= ?,customer_id_card= ?,customer_phone= ?,customer_email= ?,customer_address= ? WHERE customer_id= ?";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id          = resultSet.getInt("customer_id");
                int typeId      = resultSet.getInt("customer_type_id");
                String name     = resultSet.getString("customer_name");
                String date     = String.valueOf(resultSet.getDate("customer_birthday"));
                boolean gender  = resultSet.getBoolean("customer_gender");
                String idCard   = resultSet.getString("customer_id_card");
                String phone    = resultSet.getString("customer_phone");
                String email    = resultSet.getString("customer_email");
                String address  = resultSet.getString("customer_address");
                Customer customer = new Customer(id, typeId, name, date, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int typeId      = resultSet.getInt("customer_type_id");
                String name     = resultSet.getString("customer_name");
                String date     = String.valueOf(resultSet.getDate("customer_birthday"));
                boolean gender  = resultSet.getBoolean("customer_gender");
                String idCard   = resultSet.getString("customer_id_card");
                String phone    = resultSet.getString("customer_phone");
                String email    = resultSet.getString("customer_email");
                String address  = resultSet.getString("customer_address");
                customer = new Customer(id, typeId, name, date, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean save(Customer customer) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);

            preparedStatement.setInt    (1, customer.getTypeId());
            preparedStatement.setString (2, customer.getName());
            preparedStatement.setDate   (3, Date.valueOf(customer.getBirthDay()));
            preparedStatement.setBoolean(4, customer.isGender());
            preparedStatement.setString (5, customer.getIdCard());
            preparedStatement.setString (6, customer.getPhone());
            preparedStatement.setString (7, customer.getEmail());
            preparedStatement.setString (8, customer.getAddress());
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
    public boolean update(Customer customer) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BY_ID);

            preparedStatement.setInt    (1, customer.getTypeId());
            preparedStatement.setString (2, customer.getName());
            preparedStatement.setDate   (3, Date.valueOf(customer.getBirthDay()));
            preparedStatement.setBoolean(4, customer.isGender());
            preparedStatement.setString (5, customer.getIdCard());
            preparedStatement.setString (6, customer.getPhone());
            preparedStatement.setString (7, customer.getEmail());
            preparedStatement.setString (8, customer.getAddress());
            preparedStatement.setInt    (9, customer.getId());

            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int id          = resultSet.getInt("customer_id");
                int typeId      = resultSet.getInt("customer_type_id");
                String name1    = resultSet.getString("customer_name");
                String date     = String.valueOf(resultSet.getDate("customer_birthday"));
                boolean gender  = resultSet.getBoolean("customer_gender");
                String idCard   = resultSet.getString("customer_id_card");
                String phone    = resultSet.getString("customer_phone");
                String email    = resultSet.getString("customer_email");
                String address  = resultSet.getString("customer_address");
                customer = new Customer(id, typeId, name1, date, gender, idCard, phone, email, address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> search(String name, boolean gender) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MIX);
            preparedStatement.setString (1, "%" + name + "%");
            preparedStatement.setBoolean(2, gender);

            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int id          = resultSet.getInt("customer_id");
                int typeId      = resultSet.getInt("customer_type_id");
                String name1    = resultSet.getString("customer_name");
                String date     = String.valueOf(resultSet.getDate("customer_birthday"));
                String idCard   = resultSet.getString("customer_id_card");
                String phone    = resultSet.getString("customer_phone");
                String email    = resultSet.getString("customer_email");
                String address  = resultSet.getString("customer_address");
                customer = new Customer(id, typeId, name1, date, gender, idCard, phone, email, address);

                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
