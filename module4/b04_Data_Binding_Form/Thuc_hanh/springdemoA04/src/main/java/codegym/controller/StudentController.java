package codegym.controller;

import codegym.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/create")
    public String displayCreate(Model model) {
        List<String> listSubject = new ArrayList<>();
        listSubject.add("Toán cao cấp 1");
        listSubject.add("Tin học đại cương");
        listSubject.add("Triết học");
        listSubject.add("Hình hoạ");
        listSubject.add("Hoá đại cương");
        model.addAttribute("student", new Student());
        model.addAttribute("listSubjects", listSubject);
        return "student/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("student") Student student) {
        students.add(student);
        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String displayList(Model model) {
        model.addAttribute("students", students);
        return "student/list";
    }
}
