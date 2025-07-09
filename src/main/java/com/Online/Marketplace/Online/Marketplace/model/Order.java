package com.Online.Marketplace.Online.Marketplace.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer order_id;
    private Integer user_id;
    private Integer total_price;
    private String status; 

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public List<OrderItem> items;

    public Order() {
    }

    public Order(Integer order_id, Integer user_id, Integer total_price, String status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.status = status;
    }

public Integer getorder_id() { return order_id; }
    public void setOrder_id(Integer order_id) { this.order_id = order_id; }

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public Integer getTotal_price() { return total_price; }
    public void setTotal_price(Integer total_price) { this.total_price = total_price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    }
    
