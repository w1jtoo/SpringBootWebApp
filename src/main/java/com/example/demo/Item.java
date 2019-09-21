package com.example.demo;

public class Item {
    private String name;
    private int id;
    private ItemType type;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType(){
        return this.type.toString();
    }
    public void setType(String type){
        this.type = ItemType.valueOf(type);
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
