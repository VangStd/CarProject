package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.ServiceCar;

public interface ServiceCarRepository extends JpaRepository<ServiceCar, Long>{

}
