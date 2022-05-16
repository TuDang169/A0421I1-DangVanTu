package model.repository.impl;

import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepostoryImpl implements CustomerTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<CustomerType> findByAll() {
        List<CustomerType> classList =new ArrayList<>();
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id          = resultSet.getInt("customer_type_id");
                String nameType = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(id,nameType);
                classList.add(customerType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classList;
    }
}
