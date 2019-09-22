package com.example.demo;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private int counter = 0;
    @GetMapping("/")
    public String mainPageForm(ModelMap model)
    {

        if (counter == 0) {
            model.addAttribute("user", new User());
            counter += 1;
        }
        if (!model.containsAttribute("loggedin")) {
            model.addAttribute("loggedin", 0);
        }

        return "main";
    }

    @GetMapping("/login")
    public String logInForm(Model model)
    {
        if (counter == 0) {
            model.addAttribute("user", new User());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, ModelMap model) {
        if ((int) model.get("loggedin") == 0) {
            model.addAttribute("loggedin", 1);
        }
        return "main";
    }


    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }
}
