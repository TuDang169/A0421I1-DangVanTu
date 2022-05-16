package model.repository.impl;

import model.bean.Student;
import model.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    private BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL = "SELECT * FROM student;";
    private final String SELECT_BY_ID = "SELECT * FROM student WHERE id =?;";
    final String INSERT_INTO_STUDENT = "INSERT INTO student(`name`,birthday,class_id,point,gender,email)" +
            "values(?,?,?,?,?,?);";
    final String UPDATE_STUDENT ="call edit_student_by_id(?,?,?,?,?,?,?);";


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection=null;
        connection=baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL);
              ResultSet resultSet =preparedStatement.executeQuery();

            // dùng statement
//            Statement statement = connection.createStatement();
//            ResultSet resultSet =statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = String.valueOf(resultSet.getDate("birthday"));
                int classId = resultSet.getInt("class_id");
                int point = resultSet.getInt("point");
                boolean gender = resultSet.getBoolean("gender");
                String account = resultSet.getString("account");
                String email = resultSet.getString("email");
                Student student = new Student(id,name,date,classId,point,gender,account,email);
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
        Student student=null;
        Connection connection=null;
        connection=baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();// trả về bảng
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = String.valueOf(resultSet.getDate("birthday"));
                int classId = resultSet.getInt("class_id");
                int point = resultSet.getInt("point");
                boolean gender = resultSet.getBoolean("gender");
                String email = resultSet.getString("email");
                student = new Student(id1,name,date,classId,point,gender,email);
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

            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getBirthday()));
            preparedStatement.setInt(3, student.getClassId());
            preparedStatement.setInt(4, student.getPoint());
            preparedStatement.setBoolean(5, student.isGender());
            preparedStatement.setString(6, student.getEmail());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean update(int id, Student student) {
        Connection connection = null;
        connection = baseRepository.connectDataBase();
        boolean check =false;
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_STUDENT);

            callableStatement.setInt(1, id);
            callableStatement.setString(2, student.getName());
            callableStatement.setDate(3, Date.valueOf(student.getBirthday()));
            callableStatement.setInt(4, student.getClassId());
            callableStatement.setInt(5, student.getPoint());
            callableStatement.setBoolean(6, student.isGender());
            callableStatement.setString(7, student.getEmail());
            check = callableStatement.executeUpdate()>0;
            callableStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;

    }
}
