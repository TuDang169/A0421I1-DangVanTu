package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public List<User> findAll();

    public void insert(User user) throws SQLException;

    public User select(int id);

    public List<User> selectByCountry(String country);

    public boolean update(User user) throws SQLException;;

    public boolean remove(int id) throws SQLException;;
}
