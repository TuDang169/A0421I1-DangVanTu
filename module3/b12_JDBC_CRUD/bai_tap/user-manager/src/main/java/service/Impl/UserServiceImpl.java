package service.Impl;

import model.User;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private String demoURL= "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String demoUserName = "root";
    private String demoPassword = "codegym";

    private static final String FIND_ALL_USER        = "SELECT * FROM users";
    private static final String FIND_USER_BY_ID      = "SELECT id, name,email, country FROM user WHERE id= ?";
    private static final String FIND_USER_BY_COUNTRY = "SELECT id, name,email, country FROM user WHERE country= ?";
    private static final String INSERT_USER          = "INSERT INTO users"+" (name, email, country) VALUES"+" (?, ? ,?);";
    private static final String UPDATE_USER          = "UPDATE users SET name= ?, email= ?,country= ? WHERE id= ? ";
    private static final String REMOVE_USER          = "DELETE FROM users WHERE id= ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(demoURL, demoUserName, demoPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USER);)
        {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void insert(User user) throws SQLException {
        System.out.println(INSERT_USER);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User select(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);)
        {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name     = rs.getString("name");
                String email    = rs.getString("email");
                String country  = rs.getString("country");
                user = new User(id, name, email, country);
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectByCountry(String country) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_COUNTRY);)
        {
            preparedStatement.setString(1, country);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int    id       = rs.getInt("id");
                String name     = rs.getString("name");
                String email    = rs.getString("email");
                users.add(new User(id, name, email, country));
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER);)
            {
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());

                rowUpdated = statement.executeUpdate() > 0;
            }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_USER);)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex){
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
