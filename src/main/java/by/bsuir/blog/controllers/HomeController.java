package by.bsuir.blog.controllers;

import java.util.List;
import by.bsuir.blog.models.Post;
import by.bsuir.blog.repositories.PostRepository;
import by.bsuir.blog.exceptions.NotFoundError;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    PostRepository postRepository;

    @GetMapping({"/", "/home"})
    public String index(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {
        Post post;
        try {
            post = postRepository.getOne(id);
        } catch(EntityNotFoundException error) {
            throw new NotFoundError();
        }

        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/posts/new")
    public String newPost(Model model) {
        model.addAttribute("action", "create");
        return "form";
    }

    @PostMapping("/posts")
    public String createPost(@ModelAttribute Post post) {
        post = postRepository.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post;
        try {
            post = postRepository.getOne(id);
        } catch(EntityNotFoundException error) {
            throw new NotFoundError();
        }

        model.addAttribute("action", "edit");
        model.addAttribute("post", post);
        return "form";
    }

    @PostMapping("/posts/{id}")
    public String updatePost(@PathVariable long id, @ModelAttribute Post updatedPost) {
        Post post;
        try {
            post = postRepository.getOne(id);
        } catch(EntityNotFoundException error) {
            throw new NotFoundError();
        }

        post.setTitle(updatedPost.getTitle());
        post.setAuthor(updatedPost.getAuthor());
        post.setSubtitle(updatedPost.getSubtitle());
        post.setText(updatedPost.getText());

        postRepository.save(post);

        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/about")
    public String about() { return "about"; }
}
