package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users/login")
    public String login() {
        return "/users/login";
    }

    //To Create a new User
    @GetMapping("/users/register")
    public String register(Model model){
        model.addAttribute("user", new Users());
        return "/users/register";
    }

    @PostMapping("users/register")
    private String insertUser(@ModelAttribute Users user) {
        userDao.save(user);
        return "redirect:/users/login";
    }

}
