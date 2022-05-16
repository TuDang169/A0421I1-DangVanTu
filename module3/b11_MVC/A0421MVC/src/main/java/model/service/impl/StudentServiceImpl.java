package model.service.impl;

import model.bean.Student;
import model.repository.StudentRepository;
import model.repository.impl.StudentRepositoryImpl;
import model.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
       studentRepository.save(student);
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
