package com.Online.Marketplace.Online.Marketplace.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.Online.Marketplace.Online.Marketplace.model.Product;

public interface ProductService {
    public List<Product> getAllProducts();
    public Optional<Product> getProduct(Integer id);
    public Map<Integer, Integer> getProductStockMap();
}

