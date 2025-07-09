package com.Online.Marketplace.Online.Marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.Marketplace.Online.Marketplace.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    

}
