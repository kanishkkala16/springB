package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class securityController {
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUpPage(){
        return "signup";
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }


}
