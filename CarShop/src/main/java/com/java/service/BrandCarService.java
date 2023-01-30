package com.java.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.BrandCar;

public interface BrandCarService {

	String homeBrandCar(Model model);

	String addBrandCar(Model model);

	String addBrandCar(BrandCar brandCar, BindingResult br, Model model);

	String editBrandCar(Model model, int id);

	String editBrandCar(BrandCar brandCar, BindingResult br, Model model,HttpServletRequest request);
}
