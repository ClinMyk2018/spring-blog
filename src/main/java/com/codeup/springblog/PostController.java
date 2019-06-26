package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String post() {
        return "posts index page\n";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postID(@PathVariable int id) {
        return "view an individual post for " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "view the form for creating a post";
    }

    @PostMapping ("/posts/create")
    @ResponseBody
    public void insert() {
//        This will end up being an redirect (POSSIBLY)
    }


}
