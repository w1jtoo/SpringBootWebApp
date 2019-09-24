package com.example.demo.logic;

public class InfoContainer {
    public InfoContainer() {
        user = new User();
    }

    public User user;

    public boolean loggedIn() {
        return user.getName() == "null";
    }

    ;
}
