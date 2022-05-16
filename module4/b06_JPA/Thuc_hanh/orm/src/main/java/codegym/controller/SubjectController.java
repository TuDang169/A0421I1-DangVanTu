package codegym.controller;

import codegym.entity.Subject;
import codegym.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject/create";
    }

    @PostMapping("/create")
    public String createSubject(@ModelAttribute(name = "subject") Subject subject) {
        subjectRepository.save(subject);
        return "redirect:/subject/list";
    }

    @GetMapping("/list")
    public String displayList(Model model,
                              @RequestParam(name = "teacher", required = false) String teacher) {
        if (teacher != null) {
//            model.addAttribute("subjects", subjectRepository.findByTeacherContains(teacher));
            model.addAttribute("subjects",
                    subjectRepository.querySubjectByTeacherName("%" + teacher + "%"));
        } else {
            model.addAttribute("subjects", subjectRepository.findAll());
        }

        return "subject/list";
    }

    @GetMapping("detail/{subjectId}")
    public String displayDetail(@PathVariable String subjectId, Model model) {
        model.addAttribute("subject", subjectRepository.findById(subjectId).orElse(null));
        return "subject/detail";
    }
}
