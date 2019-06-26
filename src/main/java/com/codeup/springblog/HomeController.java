package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.codehaus.groovy.runtime.StringGroovyMethods.reverse;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String hello() {
//        return "This will be the landing page!";
//    }

//    @GetMapping("/admin/{name}")
//    @ResponseBody
//    public String helloAdmin(@PathVariable String name){
//        return "Hello admin, " + name;
//    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

    @GetMapping("/cooltrick/{word}")
    @ResponseBody
    public String cooltrick(@PathVariable String word){
//        return word.toUpperCase();
//         return String.valueOf(word.toUpperCase().charAt(3));
         return reverse(word).toUpperCase();

    }

}
