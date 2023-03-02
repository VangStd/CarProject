package com.java.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.BookingServiceCarServiceLayer;

@Controller
public class AdminBookingServiceController {

	@Autowired
	private BookingServiceCarServiceLayer bookingServiceCarServiceLayer;

	@GetMapping("/admin/home-bookingservice")
	public String showAllBooking(Model model) {
		return bookingServiceCarServiceLayer.showAllBooking(model);
	}
}
