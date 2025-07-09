package com.Online.Marketplace.Online.Marketplace.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online.Marketplace.Online.Marketplace.model.Product;
import com.Online.Marketplace.Online.Marketplace.repository.ProductRepository;
import com.Online.Marketplace.Online.Marketplace.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Map<Integer, Integer> getProductStockMap() {
    List<Product> products = productRepository.findAll();
    Map<Integer, Integer> stockMap = new HashMap<>();

    for (Product p : products) {
        stockMap.put(p.getId(), p.getstock_quantity());
    }

     return stockMap;
    }
}
