package com.example.demo.controllers;

import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @RequestMapping(value = "/result")
    public JSONArray resultForm() {
        return InfoContainer.getJson();
    }
}
