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
        return studentRepository.findById(id);
    }

    @Override
    public boolean save(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean update(int id, Student student) {
     return studentRepository.update(id,student);
    }
    // phương thức kiểm tra dữ liệu SOLID,
    public void validate(){

    }

}
