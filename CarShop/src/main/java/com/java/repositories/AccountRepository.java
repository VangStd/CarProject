package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long>{

}
