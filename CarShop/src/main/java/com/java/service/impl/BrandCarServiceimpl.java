package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.repositories.BrandCarRepository;
import com.java.service.BrandCarService;

@Service
public class BrandCarServiceimpl implements BrandCarService {

	@Autowired
	private BrandCarRepository brandCarRepository;

	@Override
	public String homeBrandCar(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listBrandCar", brandCarRepository.findAll());
		return "ad_index_brandcar";
	}
}
