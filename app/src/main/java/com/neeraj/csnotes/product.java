package com.neeraj.csnotes;

import java.util.Date;

public class product {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    int id;
    String name;
    String date;
    double price;
    public product(int id, String name, String date, double price) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
    }


    public product()
    {

    }
}

