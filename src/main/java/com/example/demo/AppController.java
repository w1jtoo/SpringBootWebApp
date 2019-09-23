package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
    public User user = new User();

    public boolean loggedIn() {
        return user.getName() == "null";
    }

    ;

    @GetMapping("/")
    public String mainPageForm(ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("loggedin", loggedIn());

        return "main";
    }

    @GetMapping("/login")
    public String logInForm(Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/main")
    public String mainForm(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("loggedin", loggedIn());
        return "main";
    }

    @PostMapping("/main")
    public String postForm(Model model) {
        return "main";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user) {
        return "result";

    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String resultForm(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("loggedin", loggedIn());

        return "result";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String resultPost(Model model) {

        return "main";
    }
}
