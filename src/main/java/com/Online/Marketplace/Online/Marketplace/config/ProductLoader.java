package com.Online.Marketplace.Online.Marketplace.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.Online.Marketplace.Online.Marketplace.model.Product;
import com.Online.Marketplace.Online.Marketplace.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Component
public class ProductLoader {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void loadProductsFromCSV() {
        try {
            if (!productRepository.findAll().isEmpty()) return; // prevent duplicate loading

            var resource = new ClassPathResource("products.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line;
            boolean first = true;

            while ((line = reader.readLine()) != null) {
                if (first) { first = false; continue; } // skip header

                String[] parts = line.split(",");
                Product p = new Product();
                p.setId(Integer.parseInt(parts[0]));
                p.setName(parts[1]);
                p.setDescription(parts[2]);
                p.setPrice(Integer.parseInt(parts[3]));
                p.setstock_quantity(Integer.parseInt(parts[4]));
                productRepository.save(p);
            }

            System.out.println("✅ Products loaded from CSV");

        } catch (Exception e) {
            System.err.println("❌ Failed to load products from CSV: " + e.getMessage());
        }
    }
}

