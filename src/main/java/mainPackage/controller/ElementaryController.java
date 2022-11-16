package mainPackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ElementaryController {

    @GetMapping("hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Hello, " + name + surname);

        return "Elementary/hello";
    }


    @GetMapping("goodbye")
    public String byePage() {
        return "Elementary/goodbye";
    }

    @GetMapping("hello/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        String result;

        switch (action) {
            case "addition":
                result = String.valueOf(a + b);
                break;
            case "substraction":
                result = String.valueOf(a - b);
                break;
            case "division":
                if (b == 0) {
                    if (a > 0) result = "infinity";
                    if (a < 0) result = "- infinity";
                }
                result = String.valueOf(a / (double) b);
                break;
            case "multiplication":
                result = String.valueOf(a * (double) b);
                break;

            default:
                result = "Enter correct Http parameters: numbers a " +
                        "and b and an action: addition, substraction, division, multiplication ";

        }


        model.addAttribute("text", result);
        return "Elementary/calculator";
    }

}
