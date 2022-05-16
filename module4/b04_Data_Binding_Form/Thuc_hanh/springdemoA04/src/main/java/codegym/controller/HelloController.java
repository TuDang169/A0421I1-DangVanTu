package codegym.controller;

import codegym.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("user", "Hậu");
        return "hello/hello";
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("hello/list");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Phong"));
        students.add(new Student(2, "Ánh"));
        students.add(new Student(3, "Khánh"));
        modelAndView.addObject("listStudents", students);
        return modelAndView;
    }
}
