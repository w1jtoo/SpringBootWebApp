package com.example.demo.logic;

import java.util.ArrayList;

public class Order {
    public Order(){
        courses = new ArrayList<PizzaName>();
    }

    private ArrayList<PizzaName> courses;
    private String clientName;
    
    public void addCourse(PizzaName course)
    {
        courses.add(course);
    }
    public boolean delCourse(PizzaName course)
    {
        return courses.remove(course);
    }

    public ArrayList<PizzaName> getCourses() {
        return courses;
    }

    public String getClientName() {
        return InfoContainer.getUser().getName();
    }
}
