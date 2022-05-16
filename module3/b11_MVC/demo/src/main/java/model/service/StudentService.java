package model.service;

import model.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    void save(Student student);
    void delete(int id);
    void update(int ind, Student student);
}
