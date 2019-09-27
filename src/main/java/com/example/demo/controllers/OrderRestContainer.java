package com.example.demo.controllers;


import com.example.demo.logic.InfoContainer;
import com.example.demo.logic.PizzaName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestContainer {

    @RequestMapping("/addorder")
    public String addOrder(@RequestParam(value="name", defaultValue="Chicago") String name) {
        PizzaName pizza;
        try {
            pizza = PizzaName.valueOf(name);
        } catch (Exception e) {
            return e.getMessage();
        }
        InfoContainer.getOrder().addCourse(pizza);
        return pizza.toString();
    }

    @RequestMapping("/delorder")
    public String delOrder(@RequestParam(value="name") String name){
        PizzaName pizza;
        boolean resultCode;
        try {
            pizza = PizzaName.valueOf(name);
        } catch (Exception e) {
            return e.getMessage();
        }
        resultCode = InfoContainer.getOrder().delCourse(pizza);

        return resultCode ? pizza.toString() : "0";
    }


}
