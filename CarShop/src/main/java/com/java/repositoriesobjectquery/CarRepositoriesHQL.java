package com.java.repositoriesobjectquery;

import java.util.List;

import com.java.entities.Car;
import com.java.entities.CarDetail;

public interface CarRepositoriesHQL {
	
	CarDetail findByCarID(long cadid);

	long getCountByProductname(String productName);
	
	List<Car> findAllByStatus();
}
