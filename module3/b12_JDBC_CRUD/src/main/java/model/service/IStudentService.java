package model.service;

import model.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Integer id);
    String save(Student student);

    List<Student> findByName(String nameStudent);

    List<Student> findByNameAndGender(String name, String gender);
}
