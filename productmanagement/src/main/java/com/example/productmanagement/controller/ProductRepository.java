package com.example.productmanagement.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
}
