package com.example.demo.logic;

import com.example.demo.logic.controllers.LoginRestController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        // TODO начинать новую сессию если не получается (невалидный юзер)
        //  то выводить в лог logger.Error
//        this.user = user;
//        if ()
}
    public static void LogOut(){
        // TODO заканичать сиссию
    }
    public static User user = new User();
    public static Order order = new Order();
}
