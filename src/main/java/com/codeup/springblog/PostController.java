package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private List<Post> getPosts() {
        return Arrays.asList(
                new Post("Post 1", "Some cool stuff 1."),
                new Post("Post 2", "Some cool stuff 2."),
                new Post("Post 3", "Some cool stuff 3."));
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", getPosts());
        return "/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return "Showing post: " + id;
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "Showing create post view";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public void insert() {
    }


}
