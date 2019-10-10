package com.example.demo.logic.controllers;

import com.example.demo.logic.InfoContainer;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @RequestMapping(value = "/result")
    public JSONArray resultForm() {
        return InfoContainer.getJson();
    }
}
