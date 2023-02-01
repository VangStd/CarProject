package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
