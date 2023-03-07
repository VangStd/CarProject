package com.java.controller.tech;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.AccountService;
import com.java.service.ServiceCar_ServiceLayer;
import com.java.service.TechHomeService;

@Controller
public class TechRequestController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ServiceCar_ServiceLayer car_ServiceLayer;

	@Autowired
	private TechHomeService techHomeService;

	@GetMapping("/tech/home-request")
	public String homeRequestTech(Model model, Principal principal) {
		return accountService.homeRequestTech(model, principal);
	}

	@GetMapping("/tech/home-request-processing")
	public String homeRequestProcessingTech(Model model, Principal principal) {
		return accountService.homeRequestProcessingTech(model, principal);
	}

	@GetMapping("/tech/home-request-all")
	public String homeAllRequestTech(Model model, Principal principal) {
		return accountService.homeAllRequestTech(model, principal);
	}

	@GetMapping("/tech/change-status-tech")
	public String changeStatusBookingServiceByTech(HttpServletRequest request) {
		return car_ServiceLayer.changeStatusBookingServiceByTech(request);
	}

	@GetMapping("/tech/send-request-tech")
	public String sendRequestChangeTech(HttpServletRequest request, Principal principal) {
		return techHomeService.sendRequestChangeTech(request, principal);
	}

	@GetMapping("/tech/notification")
	public String homeNotificationTech(Model model) {
		return techHomeService.homeNotificationTech(model);
	}

}
