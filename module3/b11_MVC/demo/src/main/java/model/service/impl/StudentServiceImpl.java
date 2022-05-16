package model.service.impl;

import model.bean.Student;
import model.repository.StudentReposity;
import model.repository.impl.StudentReposityImpl;
import model.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentReposity studentReposity = new StudentReposityImpl();
    @Override
    public List<Student> findAll() {
        return studentReposity.findAll();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
        studentReposity.save(student);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int ind, Student student) {

    }
    // phương thức kiểm tra dữ liệu SOLID,
    public void validate(){

    }
}
