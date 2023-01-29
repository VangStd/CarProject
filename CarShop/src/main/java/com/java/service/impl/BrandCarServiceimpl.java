package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.BrandCar;
import com.java.repositories.BrandCarRepositoriesCustom;
import com.java.repositories.BrandCarRepository;
import com.java.service.BrandCarService;

@Service
public class BrandCarServiceimpl implements BrandCarService {

	@Autowired
	private BrandCarRepository brandCarRepository;

	@Autowired
	private BrandCarRepositoriesCustom brandCarRepositoriesCustom;

	@Override
	public String homeBrandCar(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listBrandCar", brandCarRepository.findAll());
		return "ad_index_brandcar";
	}

	@Override
	public String addBrandCar(Model model) {
		// TODO Auto-generated method stub
		BrandCar brandCar = new BrandCar();
		model.addAttribute("brandcar", brandCar);
		return "ad_add_brandcar";
	}

	@Override
	public String addBrandCar(BrandCar brandCar, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		long checkBrandName = brandCarRepositoriesCustom.getCountByBrandname(brandCar.getBrandName());
		long checkCompanyName = brandCarRepositoriesCustom.getCountByCompanyname(brandCar.getCompanyName());
		if (br.hasErrors()) {
			model.addAttribute("brandcar", brandCar);
			return "ad_add_brandcar";
		}
		if (checkBrandName > 0) {
			br.rejectValue("brandName", "500", "Brand Name exist");
		}
		if (checkCompanyName > 0) {
			br.rejectValue("companyName", "500", "Company Name exist");
		}

		if (checkBrandName > 0 || checkCompanyName > 0) {
			model.addAttribute("brandcar", brandCar);
			return "ad_add_brandcar";
		} else {
			brandCarRepository.save(brandCar);
			return "redirect:/admin/home-brandcar";
		}
	}
}
