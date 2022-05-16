package com.codegym.controller;

import com.codegym.dao.DictionnaryDAO;
import com.codegym.model.Dictionnary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @GetMapping("dictionary")
    public String dictionary(){
        return "Dictionary";
    }

    @PostMapping("result")
    public ModelAndView result(@RequestParam String name){
        Dictionnary dictionnary = DictionnaryDAO.checkWord(name);
        if (dictionnary == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("Result");
            modelAndView.addObject("dictionary", dictionnary);
            return modelAndView;
        }
    }
}
