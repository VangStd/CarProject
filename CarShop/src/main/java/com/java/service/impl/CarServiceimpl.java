package com.java.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import com.java.dto.CarDetailDTO;
import com.java.entities.BrandCar;
import com.java.entities.Car;
import com.java.entities.CarDetail;
import com.java.entities.ImageCar;
import com.java.entities.TypeCar;
import com.java.repositories.BrandCarRepository;
import com.java.repositories.CarDetailRepository;
import com.java.repositories.CarRepository;
import com.java.repositories.ImageCarRepository;
import com.java.repositories.TypeCarRepository;
import com.java.repositoriesobjectquery.CarDetailRepositoriesHQL;
import com.java.repositoriesobjectquery.CarRepositoriesHQL;
import com.java.repositoriesobjectquery.ImageCarRepositoriesHQL;
import com.java.service.CarService;

@Service
public class CarServiceimpl implements CarService {

	String[] arrFuel = { "Gasoline", "Diesel", "Electricity" };
	String[] arrTranmission = { "Auto", "HandMade" };

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarRepositoriesHQL carRepositoriesHQL;

	@Autowired
	private CarDetailRepositoriesHQL carDetailRepositoriesHQL;

	@Autowired
	private CarDetailRepository carDetailRepository;

	@Autowired
	private TypeCarRepository typeCarRepository;

	@Autowired
	private BrandCarRepository brandCarRepository;

	@Autowired
	private ImageCarRepository imageCarRepository;

	@Autowired
	private ImageCarRepositoriesHQL imageCarRepositoriesHQL;

	@Autowired
	private Cloudinary cloudinary;

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

	@Override
	public String addCar(Model model) {
		// TODO Auto-generated method stub
		CarDetail carDetail = new CarDetail();
		model.addAttribute("car", carDetail);
		model.addAttribute("listType", typeCarRepository.findAll());
		model.addAttribute("listBrand", brandCarRepository.findAll());
		model.addAttribute("listFuel", arrFuel);
		model.addAttribute("listTranmission", arrTranmission);
		return "ad_add_car";
	}

	@Override
	public String addCar(CarDetail cardetail, BindingResult br, Model model) {
		// TODO Auto-generated method stub
		TypeCar typeCar = typeCarRepository.findById(cardetail.getCarID().getTypecarid()).get();
		BrandCar brandCar = brandCarRepository.findById(cardetail.getCarID().getBrandcarid()).get();
		long checkProductName = carRepositoriesHQL.getCountByProductname(cardetail.getCarID().getProductName());
		if (br.hasErrors()) {
			setModelAddCar(model, typeCar, brandCar, cardetail);
			return "ad_add_car";
		}
		if (checkProductName > 0) {
			setModelAddCar(model, typeCar, brandCar, cardetail);
			br.rejectValue("carID.productName", "500", "Product Name Exist ");
			return "ad_add_car";
		} else {
			try {
				Car carobj = cardetail.getCarID();
				carobj.setQuantity(1);
				carobj.setSale(0);
				carobj.setQuantityOnInVoice(0);
				carobj.setBrandID(brandCar);
				carobj.setTypeID(typeCar);
				carobj.setStatus("1");
				carRepository.save(carobj);
				String imageID = "PRO" + carobj.getCarID();
				cloudinary.uploader().destroy(imageID, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageID));
				Map mapUpload = cloudinary.uploader().upload(cardetail.getImgCar().getBytes(),
						ObjectUtils.asMap("public_id", imageID));
				String urlImage = (String) mapUpload.get("secure_url");
				cardetail.setImage(urlImage);
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String dateOfFormat = formatter.format(date).toString();
				cardetail.setDateBuy(dateOfFormat);
				carDetailRepository.save(cardetail);
				ImageCar imageCar = addImageCar(cardetail);
				imageCarRepository.save(imageCar);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/home-car";
	}

	@Override
	public String editCar(Model model, long id) {
		// TODO Auto-generated method stub
		CarDetail carDetail = carDetailRepository.findById((int) id).get();
		System.out.println("--------" + carDetail.getDateBuy());
		setModelEditCar(model, carDetail);
		return "ad_edit_car";
	}

	@Override
	public String editCar(CarDetail carDetail, BindingResult br, Model model, long id) {
		// TODO Auto-generated method stub
		TypeCar typeCar = typeCarRepository.findById(carDetail.getCarID().getTypecarid()).get();
		BrandCar brandCar = brandCarRepository.findById(carDetail.getCarID().getBrandcarid()).get();
		Car car = carRepository.findById(carDetail.getCarID().getCarID()).get();
		boolean checkEnterProductname = car.getProductName().equals(carDetail.getCarID().getProductName());
		if (!carDetail.getImgCar().isEmpty()) {
			try {
				String imageID = "PRO" + carDetail.getCarID().getCarID();
				cloudinary.uploader().destroy(imageID, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageID));
				Map mapUpload = cloudinary.uploader().upload(carDetail.getImgCar().getBytes(),
						ObjectUtils.asMap("public_id", imageID));
				String urlImage = (String) mapUpload.get("secure_url");
				carDetail.setImage(urlImage);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		if (br.hasErrors()) {
			setModelEditCar(model, typeCar, brandCar, carDetail);
			return "ad_edit_car";
		}
		if (checkEnterProductname) {
			carDetail.getCarID().setBrandID(brandCar);
			carDetail.getCarID().setTypeID(typeCar);
			carRepository.save(carDetail.getCarID());
			carDetailRepository.save(carDetail);
		} else {
			long checkProductName = carRepositoriesHQL.getCountByProductname(carDetail.getCarID().getProductName());
			if (checkProductName > 0) {
				br.rejectValue("carID.productName", "500", "Product Name Exist ");
				setModelEditCar(model, typeCar, brandCar, carDetail);
				return "ad_edit_car";
			} else {
				carDetail.getCarID().setBrandID(brandCar);
				carDetail.getCarID().setTypeID(typeCar);
				carRepository.save(carDetail.getCarID());
				carDetailRepository.save(carDetail);
			}
		}
		return "redirect:/admin/home-car";
	}

	@Override
	public String deleteCar(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("carID"));
		CarDetail carDetail = carDetailRepository.findById(id).get();
		long idCar = carDetail.getCarID().getCarID();
		String imageID = "PRO" + idCar;
		System.out.println(idCar + " " + id);
		ImageCar imageCar = imageCarRepositoriesHQL.findByCarId(idCar);
		String imageName = idCar + "";
		try {
			cloudinary.uploader().destroy(imageID, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageID));
			cloudinary.uploader().destroy(imageName + "1",
					ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName + "1"));
			cloudinary.uploader().destroy(imageName + "2",
					ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName + "2"));
			cloudinary.uploader().destroy(imageName + "3",
					ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName + "3"));
			cloudinary.uploader().destroy(imageName + "4",
					ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName + "4"));
			cloudinary.uploader().destroy(imageName + "5",
					ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName + "5"));
//			imageCarRepository.delete(imageCar);
//			carDetailRepository.delete(carDetail);
			carRepository.deleteById(idCar);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "redirect:/admin/home-car";
	}

	private void setModelAddCar(Model model, TypeCar typeCar, BrandCar brandCar, CarDetail car) {
		model.addAttribute("car", car);
		model.addAttribute("listType", typeCarRepository.findAll());
		model.addAttribute("listBrand", brandCarRepository.findAll());
		model.addAttribute("listFuel", arrFuel);
		model.addAttribute("addTypeCar", typeCar.getTypeName());
		model.addAttribute("addBrandCar", brandCar.getBrandName());
		model.addAttribute("listTranmission", arrTranmission);
		model.addAttribute("addTranmission", car.getTranmission());
		model.addAttribute("addFuel", car.getFuel());
	}

	private void setModelEditCar(Model model, CarDetail carDetail) {
		model.addAttribute("car", carDetail);
		model.addAttribute("listFuel", arrFuel);
		model.addAttribute("listTranmission", arrTranmission);
		model.addAttribute("listType", typeCarRepository.findAll());
		model.addAttribute("listBrand", brandCarRepository.findAll());
		model.addAttribute("addTranmission", carDetail.getTranmission());
		model.addAttribute("addFuel", carDetail.getFuel());
		model.addAttribute("addTypeCar", carDetail.getCarID().getTypeID().getTypeName());
		model.addAttribute("addBrandCar", carDetail.getCarID().getBrandID().getBrandName());
	}

	private void setModelEditCar(Model model, TypeCar typeCar, BrandCar brandCar, CarDetail carDetail) {
		model.addAttribute("car", carDetail);
		model.addAttribute("listFuel", arrFuel);
		model.addAttribute("listTranmission", arrTranmission);
		model.addAttribute("listType", typeCarRepository.findAll());
		model.addAttribute("listBrand", brandCarRepository.findAll());
		model.addAttribute("addTranmission", carDetail.getTranmission());
		model.addAttribute("addFuel", carDetail.getFuel());
		model.addAttribute("addTypeCar", typeCar.getTypeName());
		model.addAttribute("addBrandCar", brandCar.getBrandName());
	}

	private ImageCar addImageCar(CarDetail car) {
		ImageCar imageCar = new ImageCar();
		imageCar.setCarID(car.getCarID());
		imageCar.setImageDefault(car.getImage());
		imageCar.setImage1(car.getImage());
		imageCar.setImage2(car.getImage());
		imageCar.setImage3(car.getImage());
		imageCar.setImage4(car.getImage());
		imageCar.setImage5(car.getImage());
		return imageCar;
	}

}
