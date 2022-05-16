package model.repository.impl;

import model.bean.Student;
import model.repository.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentRepository implements IStudentRepository {

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "select id, `name`, date_of_birth, gender\n" +
                                    "from student");
            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setGender(Integer.parseInt(resultSet.getString("gender")));

                studentList.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student findById(Integer id) {

        Student student = null;
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "select id, `name`, date_of_birth, gender\n" +
                                    "from student\n" +
                                    "where id = ?");
            preparedStatement.setString(1, id + "");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student = new Student();
                student.setId(id);
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setGender(Integer.parseInt(resultSet.getString("gender")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    @Override
    public String save(Student student) {
        int row = 0;

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "update student\n" +
                                    "set `name` = ?, date_of_birth = ?\n" +
                                    "where id = ?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.setString(3, student.getId() + "");

            // INSERT, DELETE, UPDATE
            row = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return row > 0 ? "success" : "fail";
    }

    @Override
    public List<Student> findByName(String nameStudent) {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "select * from student where name like ?");
            preparedStatement.setString(1, "%" + nameStudent + "%");


            // INSERT, DELETE, UPDATE
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;

            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setGender(Integer.parseInt(resultSet.getString("gender")));

                studentList.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Student> findByNameAndGerder(String name, String gender) {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(
                            "select * from student where name like ? and gender = ?");
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, gender);


            // INSERT, DELETE, UPDATE
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;

            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setGender(Integer.parseInt(resultSet.getString("gender")));

                studentList.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }
}
