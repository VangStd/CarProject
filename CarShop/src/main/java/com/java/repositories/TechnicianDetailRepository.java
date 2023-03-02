package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.TechnicianDetail;

public interface TechnicianDetailRepository extends JpaRepository<TechnicianDetail, Long> {

}
