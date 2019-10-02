package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.PizzaName;
import com.example.demo.logic.User;
import com.example.demo.logic.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginRestController {

    @Autowired
    public UserRepository user;


    @GetMapping
    public User get(){
        return InfoContainer.getUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logInForm(@Valid @RequestBody String name) {
        // TODO use right way of initialize
        InfoContainer.StartNewSession(user.getOne(name));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delOrder() {
        InfoContainer.LogOut();
        return ResponseEntity.ok().build();
    }
}
