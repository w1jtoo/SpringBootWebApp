package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private InfoContainer container = new InfoContainer();
    private User user = container.user;


    @GetMapping("/login")
    public String logInForm(Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user) {
        return "result";
    }
}
