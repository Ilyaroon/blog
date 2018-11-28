package by.bsuir.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/post")
    public String post() {
        return "post";
    }
}
