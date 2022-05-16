package com.codegym.sessionandcookie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    HttpSession httpSession;

    @GetMapping("/login")
    public String login() {
        String username = (String) httpSession.getAttribute("user");
        if (username == null || username.isEmpty()) {
            return "login";
        }
        return "redirect:/hello";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model) {
        if ("linh".equals(username) && "1234".equals(password)) {
            httpSession.setAttribute("user", "linh");
            httpSession.setMaxInactiveInterval(10);
            httpSession.removeAttribute("name");
            return "redirect:/hello";
        }

        model.addAttribute("error", "Username hoặc password không đúng");
        return "login";
    }
}
