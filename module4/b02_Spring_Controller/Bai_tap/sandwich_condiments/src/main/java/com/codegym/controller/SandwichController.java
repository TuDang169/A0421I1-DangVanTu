package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("sanwich")
    public String sanwichCondiments(){
        return "form";
    }

    @PostMapping("selection")
    public String selectedCondiments(@RequestParam String con, Model model){
        switch (con){
            case "le":
                model.addAttribute("con", "Lettuce");
                break;
            case "to":
                model.addAttribute("con", "Tomato");
                break;
            case "mu":
                model.addAttribute("con", "Mustard");
                break;
            case "sp":
                model.addAttribute("con", "Sprouts");
                break;
        }
        return "selection";
    }
}
