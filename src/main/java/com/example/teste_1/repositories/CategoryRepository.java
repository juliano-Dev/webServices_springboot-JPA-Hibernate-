package com.example.teste_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_1.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
