package com.example.demo.logic.controllers;

import com.example.demo.logic.InfoContainer;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    Logger logger = LoggerFactory.getLogger(LoginRestController.class);

    @RequestMapping(value = "/result")
    public JSONArray resultForm() {
        logger.info("Show the result of session.");
        return InfoContainer.getJson();
    }
}
