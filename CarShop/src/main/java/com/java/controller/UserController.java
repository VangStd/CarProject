package com.java.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.BookServiceDTO;
import com.java.service.ServiceCar_ServiceLayer;

@Controller
public class UserController {

	@Autowired
	private ServiceCar_ServiceLayer serviceCar_ServiceLayer;

	@PostMapping("/user/booking-service")
	public String bookingService(@ModelAttribute("booking") @Valid BookServiceDTO bookServiceDTO, BindingResult br,
			Model model, Principal principal) {
		return serviceCar_ServiceLayer.bookingService(bookServiceDTO, br, model, principal);
	}
}
