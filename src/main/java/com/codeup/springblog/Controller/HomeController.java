package com.codeup.springblog.Controller;

import com.codeup.springblog.Model.Users;
import com.codeup.springblog.Repos.PostRepository;
import com.codeup.springblog.Services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private PostRepository postDao;
    private EmailService emailService;

    public HomeController(PostRepository postDao, EmailService emailService) {
        this.postDao = postDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts/home")
    public String returnHomePage(Model model) {
        System.out.println( SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/posts/home";
    }

    public PostRepository getPostDao() {
        return postDao;
    }

    public void setPostDao(PostRepository postDao) {
        this.postDao = postDao;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}