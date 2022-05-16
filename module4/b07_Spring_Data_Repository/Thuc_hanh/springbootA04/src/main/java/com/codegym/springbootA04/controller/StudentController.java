package com.codegym.springbootA04.controller;

import com.codegym.springbootA04.entity.Student;
import com.codegym.springbootA04.entity.Subject;
import com.codegym.springbootA04.repository.StudentRepository;
import com.codegym.springbootA04.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("students", studentRepository.getList());
        return "list";
    }

    @GetMapping("/create")
    public String displayCreate(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("student") Student student){
        Subject subject = new Subject("V001", "Văn học 10", "Khánh", null, null);
        student.setSubject(subject);
        studentRepository.createStudent(student);
        return "redirect:/student/list";
    }
}
