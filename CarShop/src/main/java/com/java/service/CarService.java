package com.java.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CarService {

	String homeCar(Model model);
	
	String viewMoreCar(Model model,HttpServletRequest request);
}
