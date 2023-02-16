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
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.entities.CarDetail;
import com.java.service.CarService;

@Controller
public class AdminCarController {

	@Autowired
	private CarService carService;

	@GetMapping("/admin/home-car")
	public String homeCar(Model model) {
		return carService.homeCar(model);
	}

	@GetMapping("/admin/viewmore-car")
	public @ResponseBody String viewMoreCar(Model model, HttpServletRequest request) {
		return carService.viewMoreCar(model, request);
	}

	@GetMapping("/admin/add-car")
	public String addCar(Model model) {
		return carService.addCar(model);
	}

	@PostMapping("/admin/add-car")
	public String addCar(@ModelAttribute("car") @Valid CarDetail car, BindingResult br, Model model) {
		return carService.addCar(car, br, model);
	}

	@GetMapping("/admin/edit-car/{id}")
	public String editCar(Model model, @PathVariable("id") long id) {
		return carService.editCar(model, id);
	}

	@PostMapping("/admin/edit-car/{id}")
	public String editCar(@ModelAttribute("car") @Valid CarDetail carDetail, BindingResult br, Model model,
			@PathVariable("id") long id) {
		return carService.editCar(carDetail, br, model, id);
	}

	@PostMapping("/admin/delete-car")
	public String deleteCar(Model model, HttpServletRequest request) {
		return carService.deleteCar(model, request);
	}

}
