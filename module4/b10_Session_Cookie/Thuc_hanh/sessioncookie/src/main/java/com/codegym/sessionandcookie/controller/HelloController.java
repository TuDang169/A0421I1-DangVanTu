package com.codegym.sessionandcookie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @Autowired
    HttpSession httpSession;

    @GetMapping("hello")
    public String hello(Model model, @CookieValue(value = "count", defaultValue = "0")
            long totalCount, HttpServletResponse response) {
        String username = (String)httpSession.getAttribute("user");
        if (username == null || username.isEmpty()) {
            return "redirect:/login";
        }

        totalCount++;
        Cookie cookie = new Cookie("count", String.valueOf(totalCount));
        cookie.setMaxAge(10);
        response.addCookie(cookie);

        model.addAttribute("user", username);
        model.addAttribute("totalCount", totalCount);

        return "hello";
    }
}
