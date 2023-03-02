package com.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.ServiceCar_ServiceLayer;

@Controller
public class ServiceCarController {

	@Autowired
	private ServiceCar_ServiceLayer serviceCar_ServiceLayer;

	@GetMapping("/service")
	public String serviceCarUser(Model model) {
		return serviceCar_ServiceLayer.serviceCarUser(model);
	}
	

	@PostMapping("/service-detail")
	public @ResponseBody String serviceCarDetailUser(HttpServletRequest request) {
		return serviceCar_ServiceLayer.serviceCarDetailUser(request);
	}
	

}
