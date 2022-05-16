package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static List<Product> productList = new ArrayList<>();
    BaseRepository baseRepository       =new BaseRepository();
    final String SELECT_ALL_PRODUCT     = "SELECT * FROM product;";
    final String INSERT_INTO_PRODUCT    = "INSERT INTO product(product_name,product_pride,product_quantity,product_color,category_id)" +
            " values(?,?,?,?,?);";
    final String SELECT_BY_ID           = "SELECT * FROM product WHERE product_id =?;";
    final String SELECT_BY_NAME         = "SELECT * FROM product WHERE product_name LIKE ?;";
    final String DELETE_BY_ID           = "DELETE FROM product WHERE product_id =?;";
    final String EDIT_BY_ID             = "UPDATE product set product_name= ?,product_pride= ?,product_quantity= ?,product_color= ?,category_id= ? WHERE product_id= ?";
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id          = resultSet.getInt("product_id");
                String name     = resultSet.getString("product_name");
                double pride    = resultSet.getDouble("product_pride");
                int quantity    = resultSet.getInt("product_quantity");
                String color    = resultSet.getString("product_color");
                int categoryId  = resultSet.getInt("category_id");
                Product product = new Product(id, name, pride, quantity, color,categoryId);
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name     = resultSet.getString("product_name");
                double pride    = resultSet.getDouble("product_pride");
                int quantity    = resultSet.getInt("product_quantity");
                String color    = resultSet.getString("product_color");
                int categoryId  = resultSet.getInt("category_id");
                product = new Product(id, name, pride, quantity, color,categoryId);
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);

            preparedStatement.setString (1, product.getName());
            preparedStatement.setDouble (2, product.getPride());
            preparedStatement.setInt    (3, product.getQuantity());
            preparedStatement.setString (4, product.getColor());
            preparedStatement.setInt    (5, product.getCategoryId());
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
    public boolean update(Product product) {
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BY_ID);

            preparedStatement.setString (1, product.getName());
            preparedStatement.setDouble (2, product.getPride());
            preparedStatement.setInt    (3, product.getQuantity());
            preparedStatement.setString (4, product.getColor());
            preparedStatement.setInt    (5, product.getCategoryId());
            preparedStatement.setInt    (6, product.getId());

            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                int id          = resultSet.getInt   ("product_id");
                String name1    = resultSet.getString("product_name");
                double pride    = resultSet.getDouble("product_pride");
                int quantity    = resultSet.getInt   ("product_quantity");
                String color    = resultSet.getString("product_color");
                int categoryId  = resultSet.getInt   ("category_id");
                product = new Product(id, name1, pride, quantity, color,categoryId);
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}
