package com.java.controller.tech;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.TechHomeService;

@Controller
public class TechHomeController {

	@Autowired
	private TechHomeService techHomeService;

	@GetMapping("/tech/home")
	public String home(Model model, Principal principal) {
		return techHomeService.homeTech(model, principal);
	}

	@GetMapping("/tech/draw-chart")
	public @ResponseBody String drawChartByTech(Model model, Principal principal) {
		return techHomeService.drawChartByTech(model, principal);
	}
}
