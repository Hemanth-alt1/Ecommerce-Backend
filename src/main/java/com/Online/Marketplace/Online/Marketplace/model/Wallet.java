package com.Online.Marketplace.Online.Marketplace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    private int user_id;

    private  int balance;

    public Wallet() {
    }

    public Wallet(int user_id, int balance) {
        this.user_id = user_id;
        this.balance = balance;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public  int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
