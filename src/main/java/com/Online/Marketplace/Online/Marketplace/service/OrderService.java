package com.Online.Marketplace.Online.Marketplace.service;

import com.Online.Marketplace.Online.Marketplace.model.Order;
import com.Online.Marketplace.Online.Marketplace.model.OrderRequest;

public interface OrderService {
    public Order createOrder(OrderRequest request);
      
}
