package model.repository.impl;

import model.bean.StudentClass;
import model.repository.ClassRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepositoryImpl implements ClassRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<StudentClass> findByAll() {
        List<StudentClass> classList =new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM class;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameClass = resultSet.getString("class_name");
                int classTypeId = resultSet.getInt("class_type_id");
                StudentClass studentClass = new StudentClass(id,nameClass,classTypeId);
                classList.add(studentClass);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classList;
    }
}
