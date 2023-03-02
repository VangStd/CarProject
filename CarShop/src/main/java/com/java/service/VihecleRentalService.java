package com.java.service;

import org.springframework.ui.Model;

public interface VihecleRentalService {
	String showCar(Model model);

	String showCarDetail(Model model, long id);
}
