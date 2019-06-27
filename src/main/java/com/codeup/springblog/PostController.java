package com.codeup.springblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class PostController {

    //understanding how the repository works!!!
    //IT IS AMAZING
    private PostRepository postDao;

    //The Dao Basically, but is given from Repository
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    //Getting all posts!
    @GetMapping("/posts")
    public String all(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    //deleting all posts!

//    @GetMapping("/posts/{title}")
//    public String deleted( @PathVariable String title) {
//        return postDao.delete(title);
//    }

    @GetMapping("/posts/create")
    private String create() {
        return "/posts/create";
    }

    //To create new posts
    @PostMapping("/posts/create")
    private String insert(
            @RequestParam String body,
            @RequestParam String title )
    {
        Post adToInsert = new Post(body, title);
        postDao.save(adToInsert);
        return "redirect:/posts/index";
    }


}
