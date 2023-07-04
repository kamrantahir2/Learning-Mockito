package com.example.LearningMockito;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Stock() {
    }

    public Stock(String id, String name, int qauntity) {
        this.id = id;
        this.name = name;
        this.quantity = qauntity;
    }
}