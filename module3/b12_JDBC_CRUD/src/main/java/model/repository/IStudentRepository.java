package model.repository;

import model.bean.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(Integer id);
    String save(Student student);

    List<Student> findByName(String nameStudent);

    List<Student> findByNameAndGerder(String name, String gender);
}
