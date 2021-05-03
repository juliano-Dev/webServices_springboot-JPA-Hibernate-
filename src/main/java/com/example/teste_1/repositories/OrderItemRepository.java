package com.example.teste_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste_1.Entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
