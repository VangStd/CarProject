package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.entities.OrderService;
import com.java.repositories.OrderServiceRepository;
import com.java.service.BookingServiceCarServiceLayer;

@Service
public class BookingServiceCarServiceLayerimpl implements BookingServiceCarServiceLayer {

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Override
	public String showAllBooking(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listBooking", orderServiceRepository.findAll());
		System.out.println("--------------" + orderServiceRepository.findAll().size());
		return "ad_index_booking";
	}
}
