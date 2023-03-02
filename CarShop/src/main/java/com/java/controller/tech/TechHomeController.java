package com.java.controller.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechHomeController {

	@GetMapping("/tech/home")
	public String home() {
		return "tech_index";
	}
}
