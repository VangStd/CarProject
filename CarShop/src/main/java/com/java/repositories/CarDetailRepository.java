package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.CarDetail;

public interface CarDetailRepository extends JpaRepository<CarDetail, Integer>{

}
