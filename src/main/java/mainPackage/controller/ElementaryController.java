package mainPackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ElementaryController
{
    @GetMapping("hello")
    public String helloPage()
    {
        return "Elementary/hello";
    }

    @GetMapping("goodbye")
    public String byePage()
    {
        return "Elementary/goodbye";
    }


}
