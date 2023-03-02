package com.java.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.entities.ServiceCar;
import com.java.service.ServiceCar_ServiceLayer;

@Controller
public class AdminServiceCarController {

	@Autowired
	private ServiceCar_ServiceLayer serviceCar_ServiceLayer;

	@GetMapping("/admin/home-servicecar")
	public String homeServiceCar(Model model) {
		return serviceCar_ServiceLayer.homeServiceCar(model);
	}

	@GetMapping("/admin/add-servicecar")
	public String addServiceCar(Model model) {
		return serviceCar_ServiceLayer.addServiceCar(model);
	}

	@PostMapping("/admin/add-servicecar")
	public String addServiceCar(@ModelAttribute("servicecar") @Valid ServiceCar serviceCar, BindingResult br,
			Model model) {
		return serviceCar_ServiceLayer.addServiceCar(serviceCar, br, model);
	}

	@GetMapping("/admin/edit-servicecar/{id}")
	public String editServiceCar(Model request, @PathVariable("id") long id) {
		return serviceCar_ServiceLayer.editServiceCar(request, id);
	}

	@PostMapping("/admin/edit-servicecar/{id}")
	public String editServiceCar(@ModelAttribute("servicecar") @Valid ServiceCar serviceCar, BindingResult br,
			Model model, HttpServletRequest request, @PathVariable("id") long id) {
		return serviceCar_ServiceLayer.editServiceCar(serviceCar, br, model, request, id);
	}

	@PostMapping("/admin/delete-servicecar")
	public String deteleServiceCar(Model model, HttpServletRequest request) {
		return serviceCar_ServiceLayer.deleteServiceCar(model, request);
	}
}
