package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainRequestController {
    private InfoContainer container = new InfoContainer();
    public User user = container.user;

    @GetMapping("/")
    public String mainPageForm(ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("loggedin", container.loggedIn());

        return "main";
    }

    @GetMapping("/main")
    public String mainForm(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("loggedin", container.loggedIn());
        return "main";
    }

    @PostMapping("/main")
    public String postForm(Model model) {
        return "main";
    }
}
