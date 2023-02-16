package com.java.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.ImageCar;

public interface ImageCarService {

	String editImageCar(Model model, long id);

	String editImageCar(ImageCar imageCar, BindingResult br, Model model, long carID);
}
