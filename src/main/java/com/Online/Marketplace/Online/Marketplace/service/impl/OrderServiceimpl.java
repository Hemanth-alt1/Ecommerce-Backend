package com.Online.Marketplace.Online.Marketplace.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online.Marketplace.Online.Marketplace.model.Order;
import com.Online.Marketplace.Online.Marketplace.model.OrderItem;
import com.Online.Marketplace.Online.Marketplace.model.OrderRequest;
import com.Online.Marketplace.Online.Marketplace.model.Product;
import com.Online.Marketplace.Online.Marketplace.model.User;
import com.Online.Marketplace.Online.Marketplace.model.Wallet;
import com.Online.Marketplace.Online.Marketplace.repository.OrderItemRepository;
import com.Online.Marketplace.Online.Marketplace.repository.OrderRepository;
import com.Online.Marketplace.Online.Marketplace.repository.ProductRepository;
import com.Online.Marketplace.Online.Marketplace.repository.UserRepository;
import com.Online.Marketplace.Online.Marketplace.repository.WalletRepository;
import com.Online.Marketplace.Online.Marketplace.service.OrderService;
import com.Online.Marketplace.Online.Marketplace.service.ProductService;
import com.Online.Marketplace.Online.Marketplace.service.WalletService;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductService productService;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    WalletService walletService;
    @Autowired
    WalletRepository walletRepository;

    @Override
public Order createOrder(OrderRequest request) {
    Integer userId = request.getUser_id();
    List<OrderItem> items = request.getItems();

    Optional<User> userOpt = userRepository.findById(userId);
    if (userOpt.isEmpty()) {
        throw new RuntimeException("User not found");
    }

    Map<Integer, Integer> stockMap = productService.getProductStockMap();

    int totalPrice = 0;
    List<OrderItem> orderItems = new ArrayList<>();
    Double totalAmount = 0.0;

    for (OrderItem item : items) {
        if (item.getProduct() == null || item.getProduct().getId() == null) {
            throw new IllegalArgumentException("Product is missing in OrderItem");
        }

        Integer productId = item.getProduct().getId();
        Integer quantity = item.getQuantity();

        if (!stockMap.containsKey(productId) || stockMap.get(productId) < quantity) {
            throw new RuntimeException("Insufficient stock for product " + productId);
        }

        Optional<Product> productOpt = productService.getProduct(productId);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found: " + productId);
        }

        Product product = productOpt.get();

        int itemPrice = product.getPrice() * quantity;
        totalPrice += itemPrice;
        totalAmount += itemPrice;

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);

        orderItems.add(orderItem);

        System.out.println("Item: " + product.getName() + " x " + quantity + " = " + itemPrice);
    }

    Wallet wallet = walletRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("Wallet not found for user: " + userId));

    System.out.println("User ID: " + userId);
    System.out.println("Total Amount: " + totalAmount);
    System.out.println("Wallet Balance: " + wallet.getBalance());

    if (wallet.getBalance() < totalAmount) {
        throw new RuntimeException("Insufficient balance. Order cannot be placed.");
    }
    wallet.setBalance((int)(wallet.getBalance() - totalAmount));
    walletRepository.save(wallet);

    Order order = new Order();
    order.setUser_id(userId);
    order.setStatus("PLACED");
    order.setTotal_price(totalPrice);
    order.setItems(orderItems); // Assign order items to order

    Order savedOrder = orderRepository.save(order);

    for (OrderItem item : orderItems) {
        item.setOrder(savedOrder);
        orderItemRepository.save(item);

        Product product = productService.getProduct(item.getProduct().getId())
            .orElseThrow(() -> new RuntimeException("Product not found with ID: " + item.getProduct().getId()));

        product.setstock_quantity(product.getstock_quantity() - item.getQuantity());
        productRepository.save(product);
    }

    return savedOrder;
}

}
