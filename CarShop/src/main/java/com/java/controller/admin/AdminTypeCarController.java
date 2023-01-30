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
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entities.TypeCar;
import com.java.service.TypeCarService;

@Controller
public class AdminTypeCarController {

	@Autowired
	private TypeCarService carService;

	@GetMapping("/admin/home-typecar")
	public String homeTypeCar(Model model) {
		return carService.homeTypeCar(model);
	}

	@GetMapping("/admin/add-typecar")
	public String addTypeCar(Model model) {
		return carService.addTypeCar(model);
	}

	@PostMapping("/admin/add-typecar")
	public String addTypeCar(@ModelAttribute("typecar") @Valid TypeCar typeCar, BindingResult br, Model model) {
		return carService.addTypeCar(typeCar, br, model);
	}

	@GetMapping("/admin/edit-typecar/{id}")
	public String editTypeCar(Model model, @PathVariable("id") int id) {
		return carService.editTypeCar(model, id);
	}

	@PostMapping("/admin/edit-typecar/{id}")
	public String editTypeCar(@ModelAttribute("typecar") @Valid TypeCar typeCar, BindingResult br, Model model,
			HttpServletRequest request, @PathVariable("id") int id) {
		return carService.editTypeCar(typeCar, br, model, request);
	}

	@PostMapping("/admin/delete-typecar")
	public String deleteTypeCar(Model model, HttpServletRequest request) {
		return carService.deleteTypeCar(model, request);
	}
}
