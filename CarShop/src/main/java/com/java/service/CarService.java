package com.java.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import com.java.entities.CarDetail;

public interface CarService {

	String homeCar(Model model);

	String viewMoreCar(Model model, HttpServletRequest request);

	String addCar(Model model);

	String addCar(CarDetail car, BindingResult br, Model model);

	String editCar(Model br, long id);

	String editCar(CarDetail carDetail, BindingResult br, Model model, long id);
	
	String deleteCar(Model model,HttpServletRequest request);

}
