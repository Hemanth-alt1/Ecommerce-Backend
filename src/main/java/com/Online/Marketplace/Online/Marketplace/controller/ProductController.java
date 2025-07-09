package com.Online.Marketplace.Online.Marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online.Marketplace.Online.Marketplace.model.Product;
import com.Online.Marketplace.Online.Marketplace.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping 
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
     
    @GetMapping("/{id}")
     public Optional<Product> getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
     }

   
}



