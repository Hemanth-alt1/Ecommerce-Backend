package com.Online.Marketplace.Online.Marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online.Marketplace.Online.Marketplace.model.Order;
import com.Online.Marketplace.Online.Marketplace.model.OrderRequest;
import com.Online.Marketplace.Online.Marketplace.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    
    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

     
}
