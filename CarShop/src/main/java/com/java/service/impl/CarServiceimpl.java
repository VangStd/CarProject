package com.java.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.java.dto.CarDetailDTO;
import com.java.entities.Car;
import com.java.entities.CarDetail;
import com.java.entities.TypeCar;
import com.java.repositories.CarRepository;
import com.java.repositoriesobjectquery.CarDetailRepositoriesHQL;
import com.java.repositoriesobjectquery.CarRepositoriesHQL;
import com.java.service.CarService;

@Service
public class CarServiceimpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarRepositoriesHQL carRepositoriesHQL;

	@Autowired
	private CarDetailRepositoriesHQL carDetailRepositoriesHQL;

	@Override
	public String homeCar(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listCar", carRepository.findAll());
		return "ad_index_car";
	}

	@Override
	public String viewMoreCar(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("carID"));
		Gson gson = new Gson();
		CarDetail carDetail = carDetailRepositoriesHQL.findByCarID(id);
		CarDetailDTO dto = new CarDetailDTO(carDetail.getId(), carDetail.getColor(), carDetail.getDateBuy(),
				carDetail.getFuel(), carDetail.getTranmission(), carDetail.getFeature(),
				carDetail.getCarID().getCarID());
		String jsonCarDetail = gson.toJson(dto);
		System.out.println("-----------------------" + jsonCarDetail);
		return jsonCarDetail;
	}
}
