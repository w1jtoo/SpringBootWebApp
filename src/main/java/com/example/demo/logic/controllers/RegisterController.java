package com.example.demo.logic.controllers;

import com.example.demo.logic.User;
import com.example.demo.logic.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController("/register")
public class RegisterController {
    Logger logger = LoggerFactory.getLogger(LoginRestController.class);
    public UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@Valid @RequestBody User user) {
        logger.info("Register new user.");
        if (!userRepository.existsById(user.getName())){
            logger.info("User already exists.");
            return ResponseEntity.badRequest().build();
        }
        userRepository.save(user);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + user.getName())
                        .build()
                        .toUri())
                .build();
    }
}