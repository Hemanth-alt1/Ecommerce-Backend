package com.Online.Marketplace.Online.Marketplace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock_quantity;

    public Product(Integer id, String name, String description, Integer price, Integer stock_quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
    }

    public Product() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getstock_quantity() {
        return stock_quantity;
    }

    public void setstock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

}
