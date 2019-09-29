package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginRestController {

    @GetMapping
    public User get(){
        return InfoContainer.getUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logInForm(@Valid @RequestBody User user) {
        // TODO use right way of initialize
        InfoContainer.StartNewSession(user.getName());
        return ResponseEntity.ok().build();
    }
}
