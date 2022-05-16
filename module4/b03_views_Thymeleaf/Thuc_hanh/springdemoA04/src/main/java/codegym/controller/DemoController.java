package codegym.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping(value = "/index",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE)
    public String index() {
        return "demo/index";
    }

    @ResponseBody
    @RequestMapping(value = "/index1",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_HTML_VALUE)
    public String index1() {
        return "sample";
    }

    @RequestMapping(value = "/display/{username}",
            method = RequestMethod.GET)
    public String display1(@PathVariable(name = "username") String user, Model model) {
        model.addAttribute("user", user);
        if (user == null || user.isEmpty()) {
            return "redirect:/demo/index";
        }
        return "demo/display";
    }

    @RequestMapping(value = "/display",
            method = RequestMethod.GET)
    public String display2(@RequestParam(name = "username") String user, Model model) {
        model.addAttribute("user", user);
        return "demo/display";
    }

    @RequestMapping(value = "/display2", method = RequestMethod.GET)
    public String display3(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "message");
        return "redirect:/demo/display?username=Thang";
    }
}
