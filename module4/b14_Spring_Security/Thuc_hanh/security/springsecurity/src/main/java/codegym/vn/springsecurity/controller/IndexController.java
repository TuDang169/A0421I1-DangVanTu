package codegym.vn.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/user/index")
    public String user() {
        return "user";
    }

    @GetMapping("/admin/index")
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/deny")
    public String denied(){
        return "denied";
    }

    @GetMapping("/logoutSuccess")
    public String logout() {
        return "logoutSuccess";
    }
}
