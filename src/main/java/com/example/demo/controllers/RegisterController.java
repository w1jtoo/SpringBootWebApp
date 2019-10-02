package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.PizzaName;
import com.example.demo.logic.User;
import com.example.demo.logic.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController("/register")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postOrder(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + user.getName()).build().toUri()).build();
    }
}