package com.example.demo.logic;

import javax.persistence.*;

@Entity
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue
    private String name;
    @Column(name="phone_number")
    private
    String phoneNumber;
    @Column(name="orders_count")
    private int countOfOrders;

    public User() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(int countOfOrders) {
        this.countOfOrders = countOfOrders;
    }
}
