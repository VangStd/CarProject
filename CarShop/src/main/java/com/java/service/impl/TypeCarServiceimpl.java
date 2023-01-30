package com.java.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.java.entities.TypeCar;
import com.java.repositories.TypeCarRepository;
import com.java.repositoriesobjectquery.TypeCarRepositoriesCustom;
import com.java.service.TypeCarService;

@Service
public class TypeCarServiceimpl implements TypeCarService {

	@Autowired
	private TypeCarRepository typeCarRepository;

	@Autowired
	private TypeCarRepositoriesCustom typeCarRepositoriesCustom;

	@Override
	public String homeTypeCar(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listTypeCar", typeCarRepository.findAll());
		return "ad_index_typecar";
	}

	@Override
	public String addTypeCar(Model model) {
		// TODO Auto-generated method stub
		TypeCar typeCar = new TypeCar();
		model.addAttribute("typecar", typeCar);
		// a
		return "ad_add_typecar";
	}

	@Override
	public String addTypeCar(TypeCar typeCar, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		long count = typeCarRepositoriesCustom.getCountByTypeName(typeCar.getTypeName());
		if (br.hasErrors()) {
			model.addAttribute("typecar", typeCar);
			return "ad_add_typecar";
		}
		if (count > 0) {
			br.rejectValue("typeName", "500", "TypeName Exist !");
			return "ad_add_typecar";
		} else {
			typeCarRepository.save(typeCar);
			return "redirect:/admin/home-typecar";
		}
	}

	@Override
	public String editTypeCar(Model model, int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		TypeCar typeCar = typeCarRepository.findById(id).get();
		model.addAttribute("typecar", typeCar);
		return "ad_edit_typecar";
	}

	@Override
	public String editTypeCar(TypeCar typeCar, BindingResult br, Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String oldTypeName = request.getParameter("typename_temp");
		boolean checkWithOldTypeName = oldTypeName.equalsIgnoreCase(typeCar.getTypeName());
		int status = 0;
		if (br.hasErrors()) {
			model.addAttribute("typecar", typeCar);
			return "ad_edit_typecar";
		}
		if (!checkWithOldTypeName) {
			long count = typeCarRepositoriesCustom.getCountByTypeName(typeCar.getTypeName());
			if (count > 0) {
				br.rejectValue("typeName", "500", "TypeName Exist !");
				status++;
			}
		}
		if (status > 0) {
			model.addAttribute("typecar", typeCar);
			return "ad_edit_typecar";
		}
		typeCarRepository.save(typeCar);
		return "redirect:/admin/home-typecar";
	}

	@Override
	public String deleteTypeCar(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("typecarID"));
			typeCarRepository.deleteById(id);
			System.out.println("---------------------" + id);
			return "redirect:/admin/home-typecar";
		} catch (Exception e) {
			System.out.println(e.toString());
			return "err";
		}
	}
}
