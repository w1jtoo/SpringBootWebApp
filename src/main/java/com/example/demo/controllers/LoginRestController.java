package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginRestController {
    private User user = InfoContainer.getUser();


    @RequestMapping("/login")
    public User logInForm(@RequestParam(value="name", defaultValue="Vasya1") String name) {
        user.setName(name);
        return user;
    }
}
