package codegym.controller;

import codegym.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", "Khánh");
        Student student = new Student(1, "Bảo", 22, "Đà Nẵng");
        model.addAttribute("stu", student);
//        model.addAttribute("message", "Demo message");
        return "welcome";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bảo", 22, "Đà Nẵng"));
        students.add(new Student(2, "Khánh", 21, "Đà Nẵng"));
        students.add(new Student(3, "Huyền", 20, "Đà Nẵng"));
        students.add(new Student(4, "Hải", 21, "Đà Nẵng"));
        model.addAttribute("students", students);
//        model.addAttribute("message", "Demo message");
        return "list";
    }
}
