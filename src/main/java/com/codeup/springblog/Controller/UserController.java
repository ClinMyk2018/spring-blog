package com.codeup.springblog.Controller;

import com.codeup.springblog.Repos.UserRepository;
import com.codeup.springblog.Model.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/register")
    public String registerForm(Model model){
        model.addAttribute("user", new Users());
        return "users/register";
    }

    @PostMapping("/users/register")
    public String saveUser(@ModelAttribute Users user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/users/login";
    }

}
