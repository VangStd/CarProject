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

import com.java.entities.BrandCar;
import com.java.service.BrandCarService;

@Controller
public class AdminBrandCarController {

	@Autowired
	private BrandCarService brandCarService;

	@GetMapping("/admin/home-brandcar")
	public String homeBrandCar(Model model) {
		return brandCarService.homeBrandCar(model);
	}

	@GetMapping("/admin/add-brandcar")
	public String addBrandCar(Model model) {
		return brandCarService.addBrandCar(model);
	}

	@PostMapping("/admin/add-brandcar")
	public String addBrandCar(@ModelAttribute("brandcar") @Valid BrandCar brandCar, BindingResult br, Model model) {
		return brandCarService.addBrandCar(brandCar, br, model);
	}

	@GetMapping("/admin/edit-brandcar/{id}")
	public String editBrandCar(Model model, @PathVariable("id") int id) {
		return brandCarService.editBrandCar(model, id);
	}

	@PostMapping("/admin/edit-brandcar/{id}")
	public String editBrandCar(@ModelAttribute("brandcar") @Valid BrandCar brandCar, BindingResult br, Model model,
			HttpServletRequest request, @PathVariable("id") int id) {
		return brandCarService.editBrandCar(brandCar, br, model, request);
	}
}
