package com.codegym.springbootA04.restcontroller;

import com.codegym.springbootA04.entity.Student;
import com.codegym.springbootA04.entity.StudentForm;
import com.codegym.springbootA04.entity.Subject;
import com.codegym.springbootA04.repository.StudentRepository;
import com.codegym.springbootA04.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestStudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/api/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") int id) {
        Student student = studentRepository.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/api/student/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentById() {
        return studentRepository.getList();
    }

    @PostMapping("/api/student/create")
    @ResponseStatus(HttpStatus.OK)
    public String createStudent(@RequestBody StudentForm studentForm) {
        Student student = new Student(studentForm.getId(), studentForm.getName(),
                studentForm.getAge(), studentForm.getAddress());
        student.setSubject(subjectRepository.findById(studentForm.getSubjectId()).orElse(null));
        studentRepository.createStudent(student);
        return "Success";
    }

    @GetMapping("/api/student/searchTeacherName")
    @ResponseStatus(HttpStatus.OK)
    public List<Subject> searchTeacher(@RequestParam("nameTeacher") String name) {
        return subjectRepository.findByTeacherContains(name);
    }
}
