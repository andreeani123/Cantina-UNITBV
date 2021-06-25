package com.example.cantinaunitbv;

import java.util.ArrayList;
import java.util.UUID;

public class OrderHelperClass {
    String email;
    ArrayList<String> items;
    ArrayList<String> itemNames;
    double price;

    public OrderHelperClass() {

    }

    public OrderHelperClass(String email, ArrayList<String> items, ArrayList<String> itemNames, double price) {
        this.email = email;
        this.items = items;
        this.price = price;
        this.itemNames = itemNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(ArrayList<String> itemNames) {
        this.itemNames = itemNames;
    }
}
