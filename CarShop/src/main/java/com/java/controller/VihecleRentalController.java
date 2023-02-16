package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.VihecleRentalService;

@Controller
public class VihecleRentalController {

	@Autowired
	private VihecleRentalService vihecleRentalService;

	@GetMapping("/vihecle-rental")
	public String vihecleretal(Model model) {
		return vihecleRentalService.showCar(model);
	}

}
