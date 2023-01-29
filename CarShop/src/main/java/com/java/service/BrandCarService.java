package com.java.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.BrandCar;

public interface BrandCarService {

	String homeBrandCar(Model model);

	String addBrandCar(Model model);

	String addBrandCar(BrandCar brandCar, BindingResult br, Model model);
}
