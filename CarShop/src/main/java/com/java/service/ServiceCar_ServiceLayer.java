package com.java.service;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.dto.BookServiceDTO;
import com.java.entities.ServiceCar;

public interface ServiceCar_ServiceLayer {

	String homeServiceCar(Model model);

	String addServiceCar(Model model);

	String addServiceCar(ServiceCar serviceCar, BindingResult br, Model model);

	String editServiceCar(Model model, long id);

	String editServiceCar(ServiceCar serviceCar, BindingResult br, Model model, HttpServletRequest request, long id);

	String deleteServiceCar(Model model, HttpServletRequest request);

	// user

	String serviceCarUser(Model model);

	@Transactional
	String bookingService(BookServiceDTO bookServiceDTO, BindingResult br, Model model, Principal principal);

	String serviceCarDetailUser(HttpServletRequest request);

	// tech

	@Transactional
	String changeStatusBookingServiceByTech(HttpServletRequest httpServletRequest);

}
