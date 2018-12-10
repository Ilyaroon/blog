package by.bsuir.blog.controllers;

import by.bsuir.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable int id, Model model) {
        Post post = new Post("Test post", "Bla bla bla", "Ilya Runov");
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/about")
    public String about() { return "about"; }

    @GetMapping("/new_post")
    public String newPost() { return "new_post"; }

    @PostMapping("/post")
    public String createPost(@ModelAttribute Post post) {
        System.out.println(post.title);
        return null;
    }
}