package com.example.demo.logic;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public final class InfoContainer {

    public static User getUser() {
        return user;
    }

    public static Order getOrder() {
        return order;
    }
    public static JSONArray getJson(){
        var array = new JSONArray();
        array.put(user);
        array.put(order);
        return array;
    }
    public static void StartNewSession(User user){
//        this.user = user;
//        if ()
}
    public static void LogOut(){
        // TODO
    }
    public static User user = new User();
    public static Order order = new Order();
}
