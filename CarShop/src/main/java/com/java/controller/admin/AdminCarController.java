package com.java.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.CarService;

@Controller
public class AdminCarController {

	@Autowired
	private CarService carService;

	@GetMapping("/admin/home-car")
	public String homeCar(Model model) {
		return carService.homeCar(model);
	}
	
	@GetMapping("/admin/viewmore-car")
	public @ResponseBody String viewMoreCar(Model model,HttpServletRequest request) {
		return carService.viewMoreCar(model, request);
	}
}
