package transfer.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TransferController {

    @GetMapping("/form")
    public String showForm(){
        return "form";
    }

    @PostMapping("/usd")
    public String submitForm(@RequestParam String usd,
                             @RequestParam String rate,
                             Model model){
        float result = Float.parseFloat(usd) * Float.parseFloat(rate);
        model.addAttribute("result", result);
        return "submit";
    }
}
