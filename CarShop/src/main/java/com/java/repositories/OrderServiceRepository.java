package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.OrderService;

public interface OrderServiceRepository extends JpaRepository<OrderService, Integer> {

}
