package model.service.impl;

import model.bean.Student;
import model.repository.StudentRepository;
import model.repository.impl.StudentRepositoryImpl;
import model.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository =new StudentRepositoryImpl();
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
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public boolean delete(String id) {
        return studentRepository.delete(id);
    }

    @Override
    public void update(int id, Student student) {
      studentRepository.update(id,student);
    }

    @Override
    public List<Student> search(String name, String email, String classId) {
        return studentRepository.search(name,email,classId);
    }
}
