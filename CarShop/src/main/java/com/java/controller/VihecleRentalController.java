package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.service.VihecleRentalService;

@Controller
public class VihecleRentalController {

	@Autowired
	private VihecleRentalService vihecleRentalService;

	@GetMapping("/vihecle-rental")
	public String vihecleRetal(Model model) {
		return vihecleRentalService.showCar(model);
	}

	@GetMapping("/vihecle-detail/{id}")
	public String vihecleRetalDetail(Model model, @PathVariable("id") long carid) {
		return vihecleRentalService.showCarDetail(model, carid);
	}

}
