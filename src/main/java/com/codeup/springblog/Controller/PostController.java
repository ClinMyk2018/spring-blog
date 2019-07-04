package com.codeup.springblog.Controller;

import com.codeup.springblog.Model.Post;
import com.codeup.springblog.Model.Users;
import com.codeup.springblog.Repos.PostRepository;
import com.codeup.springblog.Services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, EmailService emailService) {
        this.postDao = postDao;
        this.emailService = emailService;
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
        post.setUser((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postDao.save(post);
        emailService.prepareAndSend(post, "Post created", "<h1>You have created a new post</h1>");
        return "redirect:/posts";
    }

        //Editing a current Post
        @GetMapping("/posts/{id}/edit")
        public String edit ( @PathVariable long id, Model model){
                model.addAttribute("post", postDao.findOne(id));
                return "posts/edit";
        }

        @PostMapping("/posts/{id}/edit")
        public String update (
        @PathVariable long id,
        @ModelAttribute Post post)
        {
            post.setUser((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            postDao.save(post);
            emailService.prepareAndSend(post, "Post edited", "Your post was edited");
            return "redirect:/posts";
        }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        emailService.prepareAndSend
                (postDao.findOne(id), "Post deleted", "You have deleted the post");
        postDao.delete(id);
        return "redirect:/posts";
    }

}