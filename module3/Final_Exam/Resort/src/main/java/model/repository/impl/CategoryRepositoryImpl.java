package model.repository.impl;

import model.bean.Category;
import model.repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Category> findByAll() {
        List<Category> categoryList =new ArrayList<>();
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id          = resultSet.getInt("category_id");
                String nameType = resultSet.getString("category_name");
                Category category = new Category(id,nameType);
                categoryList.add(category);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }
}
