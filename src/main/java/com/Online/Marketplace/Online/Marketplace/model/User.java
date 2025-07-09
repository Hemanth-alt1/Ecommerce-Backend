package com.Online.Marketplace.Online.Marketplace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private boolean  discount_availed=false;
        
    public User() {
    }

    public User(Integer id, String name, String email,boolean discount_availed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.discount_availed = discount_availed;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean getdiscount_availed() {
        return discount_availed;
    }

    public void setdiscount_availed(boolean  discount_availed) {
        this.discount_availed = discount_availed;
    }
}

