package mainPackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@GetMapping("/people")
public class PeopleController{

    @GetMapping()
    public String index()
    {
        return null;
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        return null;
    }
}
