package com.java.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.TypeCar;

public interface TypeCarService {
	
	String homeTypeCar(Model model);
	
	String addTypeCar(Model model);
	
	String addTypeCar(TypeCar typeCar,BindingResult br,Model model);
	
	String editTypeCar(Model model,int id);
	
	String editTypeCar( TypeCar typeCar, BindingResult br, Model model);
	
	String deleteTypeCar(Model model, HttpServletRequest request);

}
