package mainPackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondController{
    @GetMapping("exit")
    public String exit(@RequestParam(value="text", required = false) String text, Model model){
        model.addAttribute("text", text);

        return "Second/exit";
    }
}
