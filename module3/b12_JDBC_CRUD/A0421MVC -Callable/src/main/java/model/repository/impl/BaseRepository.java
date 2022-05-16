package model.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
   public Connection connectDataBase() {
        // Khai báo URL (port mysql://localhost:3306 + tên database: manager_students(thay đổi)
        final String URL = "jdbc:mysql://localhost:3306/a04_student_manager_querry?useSSL=false";
        // khai báo user: root (mặt định của mysql)
        final String USER = "root";
        // khai báo password (lúc bạn cài đặt mysql server)
        final String PASSWORD = "codegym";
        Connection connection = null;
        try {
            // Khai báo Driver của mysql: không đổi
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                // tạo 1 kết nối
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
