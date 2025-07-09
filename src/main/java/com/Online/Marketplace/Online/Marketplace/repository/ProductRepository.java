package com.Online.Marketplace.Online.Marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.Marketplace.Online.Marketplace.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

