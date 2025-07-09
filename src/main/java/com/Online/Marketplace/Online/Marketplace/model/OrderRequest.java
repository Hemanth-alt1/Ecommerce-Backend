package com.Online.Marketplace.Online.Marketplace.model;

import java.util.List;

public class OrderRequest {
    private Integer user_id;
    private List<OrderItem> items;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}