package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.ProcessBookingService;

public interface ProcessBookingServiceRepository extends JpaRepository<ProcessBookingService, Integer> {

}
