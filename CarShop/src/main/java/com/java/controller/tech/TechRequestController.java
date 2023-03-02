package com.java.controller.tech;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.AccountService;
import com.java.service.ServiceCar_ServiceLayer;

@Controller
public class TechRequestController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ServiceCar_ServiceLayer car_ServiceLayer;

	@GetMapping("/tech/home-request")
	public String homeRequestTech(Model model, Principal principal) {
		return accountService.homeRequestTech(model, principal);
	}

	@GetMapping("/tech/change-status-tech")
	public String changeStatusBookingServiceByTech(HttpServletRequest request) {
		return car_ServiceLayer.changeStatusBookingServiceByTech(request);
	}
}
