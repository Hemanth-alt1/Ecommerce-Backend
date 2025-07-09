package com.Online.Marketplace.Online.Marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.Marketplace.Online.Marketplace.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // Additional query methods can be defined here if needed

}
