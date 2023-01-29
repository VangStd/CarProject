package com.java.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.BrandCarService;

@Controller
public class AdminBrandCarController {

	@Autowired
	private BrandCarService brandCarService;

	@GetMapping("/admin/home-brandcar")
	public String homeBrandCar(Model model) {
		//s
		//vang changed
		int i = 2;
		return brandCarService.homeBrandCar(model);
	}
}
