package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class PostController {

    //understanding how the repository works!!!
    //IT IS AMAZING
    private PostRepository postDao;

    //The Dao Basically, but is given from Repository
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/login")
    public String login(){
        return "/posts/login";
    }

    @GetMapping("/posts/register")
    public String register(){
        return "/posts/register";
    }

    //Getting all posts!
    @GetMapping("/posts")
    public String all(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //Show one post, by ID #
    @GetMapping("/posts/{id")
    public String show(@PathVariable int id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(){
        return "/posts/create";
    }

    //To Create a new Post
    @PostMapping("posts/create")
    private String insertPost(
            @RequestParam String title,
            @RequestParam String body
    ){
        Post newPost = new Post(body, title);
        postDao.save(newPost);
        return "redirect:/posts";
    }

    //Editing a current Post
    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Post post = postDao.findOne(id);
        System.out.println(post);
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(
            @PathVariable int id,
            @RequestParam String title,
            @RequestParam String body) {

        Post postToEdit = new Post(id, body, title);
        postDao.save(postToEdit);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable int id) {
        postDao.delete(id);
        return "redirect:/posts";
    }

}
