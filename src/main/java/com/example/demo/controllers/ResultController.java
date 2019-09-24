package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {
    private InfoContainer container = new InfoContainer();
    public User user = container.user;

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String resultForm(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("loggedin", container.loggedIn());

        return "result";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String resultPost(Model model) {

        return "main";
    }
}
