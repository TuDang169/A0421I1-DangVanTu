package model.repository.impl;

import model.bean.Student;
import model.bean.StudentClass;
import model.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    BaseRepository baseRepository = new BaseRepository();
    final String SELECT_ALL_STUDENT = "SELECT * FROM student;";
    final String INSERT_INTO_STUDENT = "INSERT INTO student(`name`,birthday,class_id,point,gender,email)" +
            " values(?,?,?,?,?,?);";
    final String SELECT_BY_ID = "SELECT * FROM student WHERE id =?;";
    final String SELECT_BY_ID2 = "";
    final String DELETE_BY_ID = "DELETE FROM student WHERE id =?;";
    final String DELETE_BY_ID2 = "DELETE FROM student WHERE id =";
    final String EDIT_BY_ID = "call edit_student_by_id(?,?,?,?,?,?,?);";
    final String SEARCH = "SELECT * FROM student WHERE name like ? and email like ? and class_id like ?;";



    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = String.valueOf(resultSet.getDate("birthday"));
                int classId = resultSet.getInt("class_id");
                int point = resultSet.getInt("point");
                boolean gender = resultSet.getBoolean("gender");
                String account = resultSet.getString("account");
                String email = resultSet.getString("email");
                Student student = new Student(id, name, date, classId, point, gender, account, email);
                studentList.add(student);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        Student student=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = String.valueOf(resultSet.getDate("birthday"));
                int classId = resultSet.getInt("class_id");
                int point = resultSet.getInt("point");
                boolean gender = resultSet.getBoolean("gender");
                String account = resultSet.getString("account");
                String email = resultSet.getString("email");
                 student = new Student(id1, name, date, classId, point, gender, account, email);
                studentList.add(student);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean save(Student student) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        boolean check =false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENT);

            preparedStatement.setString (1, student.getName());
            preparedStatement.setDate   (2, Date.valueOf(student.getBirthday()));
            preparedStatement.setInt    (3, student.getClassId());
            preparedStatement.setInt    (4, student.getPoint());
            preparedStatement.setBoolean(5, student.isGender());
            preparedStatement.setString (6, student.getEmail());
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
        connection = baseRepository.connectDataBase();
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
    public boolean delete(String id) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        boolean check =false;
        try {
            Statement statement = connection.createStatement();
//            preparedStatement.setInt(1, id);
            check = statement.execute(DELETE_BY_ID2+id+";");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean update(int ind, Student student) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        boolean check =false;
        try {
           CallableStatement callableStatement = connection.prepareCall(EDIT_BY_ID);
            check = callableStatement.executeUpdate()>0;
            callableStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Student> search(String searchName, String searchEmail, String searchClassId) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            String string1 ="%"+searchName+"%";
            String string2 ="%"+searchEmail+"%";
            String string3 ="%"+searchClassId+"%";
            preparedStatement.setString(1,string1);
            preparedStatement.setString(2,string2);
            preparedStatement.setString(3,string3);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = String.valueOf(resultSet.getDate("birthday"));
                int classId = resultSet.getInt("class_id");
                int point = resultSet.getInt("point");
                boolean gender = resultSet.getBoolean("gender");
                String account = resultSet.getString("account");
                String email = resultSet.getString("email");
                Student student = new Student(id, name, date, classId, point, gender, account, email);
                studentList.add(student);
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }
}
