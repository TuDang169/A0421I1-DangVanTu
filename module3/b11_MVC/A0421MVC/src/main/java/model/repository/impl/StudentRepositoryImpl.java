package model.repository.impl;

import model.bean.Student;
import model.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh","12-12-1985",1,9,true,"chanh@gmial","chanh@gmial"));
        studentList.add(new Student(2,"chanh2","12-12-1985",1,9,true,"chanh@gmial","chanh@gmial"));
        studentList.add(new Student(3,"chanh3","12-12-1985",1,9,true,"chanh@gmial","chanh@gmial"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
      studentList.add(student);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int ind, Student student) {

    }
}
