package model.repository;

import model.bean.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
    void delete(int id);
    boolean update(int ind, Student student);

}
