package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerServiceImpl;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String showForm(){
        return "create";
    }

    @PostMapping("/create")
    public String submitForm(@RequestParam String username,
                             @RequestParam String password,
                             Model model){

        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "display";
    }
}
