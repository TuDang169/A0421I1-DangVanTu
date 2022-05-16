package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    private List<Email> emails =new ArrayList<>();

    @GetMapping("form")
    public String displayForm(Model model){

        List<String> listLanguage =new ArrayList<>();
        listLanguage.add("Vietnamese");
        listLanguage.add("English");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        model.addAttribute("listLanguage", listLanguage);

        List<Integer> listSize = new ArrayList<>();
        listSize.add(5);
        listSize.add(10);
        listSize.add(15);
        listSize.add(25);
        listSize.add(50);
        listSize.add(100);
        model.addAttribute("listSize", listSize);

        model.addAttribute("email", new Email());
        return "form";
    }

    @PostMapping("form")
    public String save(@ModelAttribute("email") Email email){
            emails.add(email);
        return "redirect:/save";
    }

    @GetMapping("save")
    public String display(Model model) {
        model.addAttribute("emails", emails);
        return "save";
    }
}
