package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.TypeCar;

public interface TypeCarRepository extends JpaRepository<TypeCar, Integer> {

}
