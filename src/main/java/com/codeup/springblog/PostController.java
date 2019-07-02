package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    //To Create a new Post
    @PostMapping("posts/create")
    private String insertPost(@ModelAttribute Post post){
        post.setUser(userDao.findOne(3L));
        postDao.save(post);
        emailService.prepareAndSend(post, "Post created", "You have created a new post");
        return "redirect:/posts";
    }

    //Editing a current Post
    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(
            @PathVariable long id,
            @ModelAttribute Post post)
    {
        post.setUser(userDao.findOne(1L));
        postDao.save(post);
        emailService.prepareAndSend(post, "Post edited", "Your post was edited");
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        emailService.prepareAndSend
                (postDao.findOne(1L), "Post deleted", "You have deleted the post");
        return "redirect:/posts";
    }

}