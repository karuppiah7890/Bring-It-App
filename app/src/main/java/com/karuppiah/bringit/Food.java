package com.karuppiah.bringit;

public class Food {

    private long id;
    private String name;
    private int price;

    public Food(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getID() {
        return id;
    }

    public String getNamet() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}