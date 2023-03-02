package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.entities.Car;
import com.java.repositories.CarRepository;
import com.java.repositoriesobjectquery.CarRepositoriesHQL;
import com.java.service.VihecleRentalService;

@Service
public class VihecleRentalServiceimpl implements VihecleRentalService {

	@Autowired
	private CarRepositoriesHQL carRepositoriesHQL;
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public String showCar(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listCar", carRepositoriesHQL.findAllByStatus());
		return "viheclerental";
	}

	@Override
	public String showCarDetail(Model model, long id) {
		// TODO Auto-generated method stub
		Car car = carRepository.findById(id).get();
		model.addAttribute("car", car);
		return "viheclerental_detail";
	}
}
