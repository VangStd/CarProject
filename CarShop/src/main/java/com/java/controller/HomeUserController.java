package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.repositoriesobjectquery.TechnicianDetailRepositoriesHQL;
import com.java.service.AccountService;

@Controller
public class HomeUserController {
	// http://localhost:8080/CarShop/

	@Autowired
	private AccountService accountService;

	@Autowired
	private TechnicianDetailRepositoriesHQL technicianDetailRepositoriesHQL;

	@GetMapping(value = { "/", "/home" })
	public String home() {
		System.out.println("------------------"+technicianDetailRepositoriesHQL.findByRequestProcessingDESC().getTechnicianID()+" "+technicianDetailRepositoriesHQL.findByRequestProcessingDESC().getRequest()+" "+technicianDetailRepositoriesHQL.findByRequestProcessingDESC().getRequestProcessing());
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		System.out.println(accountService.findAll().size());
		return "about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/booking")
	public String booking() {
		return "booking";
	}

	@GetMapping("/technicians")
	public String technicians() {
		return "technicians";
	}

	@GetMapping("/testimonial")
	public String testimonial() {
		return "testimonial";
	}

}
