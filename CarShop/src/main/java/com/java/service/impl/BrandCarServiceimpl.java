package com.java.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.BrandCar;
import com.java.repositories.BrandCarRepository;
import com.java.repositoriesobjectquery.BrandCarRepositoriesCustom;
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
		long checkPhone = brandCarRepositoriesCustom.getCountByPhone(brandCar.getPhone());
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
		if (checkPhone > 0) {
			br.rejectValue("phone", "500", "Phone exist");
		}

		if (checkBrandName > 0 || checkCompanyName > 0 || checkPhone > 0) {
			model.addAttribute("brandcar", brandCar);
			return "ad_add_brandcar";
		}
		brandCarRepository.save(brandCar);
		return "redirect:/admin/home-brandcar";
	}

	@Override
	public String editBrandCar(Model model, int id) {
		// TODO Auto-generated method stub
		BrandCar brandCar = brandCarRepository.findById(id).get();
		model.addAttribute("brandcar", brandCar);
		return "ad_edit_brandcar";
	}

	@Override
	public String editBrandCar(BrandCar brandCar, BindingResult br, Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String oldCompanyName = request.getParameter("companyname_temp");
		String oldBrandName = request.getParameter("brandname_temp");
		String oldPhone = request.getParameter("phone_temp");
		boolean checkEnterNewValueCompanyName = brandCar.getCompanyName().equalsIgnoreCase(oldCompanyName);
		boolean checkEnterNewValueBrandName = brandCar.getBrandName().equalsIgnoreCase(oldBrandName);
		boolean checkEnterNewValuePhone = brandCar.getPhone().equalsIgnoreCase(oldPhone);
		int status = 0;
		if (br.hasErrors()) {
			model.addAttribute("brandcar", brandCar);
			return "ad_edit_brandcar";
		}
		if (!checkEnterNewValueCompanyName) {
			long checkCompanyName = brandCarRepositoriesCustom.getCountByCompanyname(brandCar.getCompanyName());
			if (checkCompanyName > 0) {
				br.rejectValue("companyName", "500", "Company Name exist");
				status++;
			}
		}
		if (!checkEnterNewValueBrandName) {
			long checkBrandName = brandCarRepositoriesCustom.getCountByBrandname(brandCar.getBrandName());
			if (checkBrandName > 0) {
				br.rejectValue("brandName", "500", "Brand Name exist");
				status++;
			}
		}
		if (!checkEnterNewValuePhone) {
			long checkPhone = brandCarRepositoriesCustom.getCountByPhone(brandCar.getPhone());
			if (checkPhone > 0) {
				br.rejectValue("phone", "500", "Phone exist");
				status++;
			}
		}

		if (status > 0) {
			model.addAttribute("brandcar", brandCar);
			return "ad_edit_brandcar";
		}
		brandCarRepository.save(brandCar);
		return "redirect:/admin/home-brandcar";
	}

	@Override
	public String deleteBrandCar(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("brandID"));
		brandCarRepository.deleteById(id);
		return "redirect:/admin/home-brandcar";
	}
}
