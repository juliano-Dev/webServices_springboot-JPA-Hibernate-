package com.example.teste_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_1.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
