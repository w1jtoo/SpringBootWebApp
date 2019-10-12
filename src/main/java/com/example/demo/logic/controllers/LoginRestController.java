package com.example.demo.logic.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import com.example.demo.logic.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginRestController {
    public UserRepository user;
    Logger logger = LoggerFactory.getLogger(LoginRestController.class);

    @GetMapping
    public User get(){
        logger.info("Show user state.");
        return InfoContainer.getUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logInForm(@Valid @RequestBody String name) {
        // TODO иницализировать user правильно
        logger.info("User " + name + " tries to log in.");
        if (user.existsById(name)) {
            InfoContainer.StartNewSession(user.getOne(name));
            return ResponseEntity.ok().build();
        }
        else
            {
                logger.info("User " + name + " does not exist.");
                return ResponseEntity.badRequest().build();
            }
    }

    @DeleteMapping
    public ResponseEntity delOrder() {
        InfoContainer.LogOut();
        logger.info("User tries to log out.");
        return ResponseEntity.ok().build();
    }
}
