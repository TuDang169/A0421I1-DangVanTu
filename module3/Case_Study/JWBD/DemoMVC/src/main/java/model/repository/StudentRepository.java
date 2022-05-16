package model.repository;

import model.bean.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
    boolean delete(int id);
    boolean delete(String id);
    boolean update(int ind, Student student);
    List<Student> search(String name,String email,String classId);
}
