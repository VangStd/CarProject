package com.java.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.entities.ImageCar;
import com.java.service.ImageCarService;

@Controller
public class AdminImageCarController {

	@Autowired
	private ImageCarService imageCarService;

	@GetMapping("/admin/edit-imagecar/{id}")
	public String editImageCar(Model model, @PathVariable("id") long id) {
		return imageCarService.editImageCar(model, id);
	}

	@PostMapping("/admin/edit-imagecar/{id}")
	public String editImageCar(@ModelAttribute("imagecar") @Valid ImageCar imageCar, BindingResult br, Model model,
			@PathVariable("id") long id) {
		return imageCarService.editImageCar(imageCar, br, model, id);
	}
}
