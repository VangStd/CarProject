package com.java.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.entities.Car;
import com.java.entities.ImageCar;
import com.java.repositories.CarRepository;
import com.java.repositories.ImageCarRepository;
import com.java.repositoriesobjectquery.ImageCarRepositoriesHQL;
import com.java.service.ImageCarService;

@Service
public class ImageCarServiceimpl implements ImageCarService {

	@Autowired
	private ImageCarRepositoriesHQL imageCarRepositoriesHQL;

	@Autowired
	private ImageCarRepository imageCarRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private Cloudinary cloudinary;

	@Override
	public String editImageCar(Model model, long id) {
		// TODO Auto-generated method stub
		ImageCar imageCar = imageCarRepositoriesHQL.findByCarId(id);
		System.out.println(imageCar.getCarID().getProductName());
		model.addAttribute("imagecar", imageCar);
		return "ad_edit_imagecar";
	}

	@Override
	public String editImageCar(ImageCar imageCar, BindingResult br, Model model, long carID) {
		// TODO Auto-generated method stub
		Car car = carRepository.findById(imageCar.getCarID().getCarID()).get();
		if (!imageCar.getImg1().isEmpty()) {
			try {
				String imageName = imageCar.getCarID().getCarID() + "1";
				cloudinary.uploader().destroy(imageName,
						ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
				Map mapUpload = cloudinary.uploader().upload(imageCar.getImg1().getBytes(),
						ObjectUtils.asMap("public_id", imageName));
				String urlImage = (String) mapUpload.get("secure_url");
				imageCar.setImage1(urlImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (!imageCar.getImg2().isEmpty()) {
			try {
				String imageName = imageCar.getCarID().getCarID() + "2";
				cloudinary.uploader().destroy(imageName,
						ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
				Map mapUpload = cloudinary.uploader().upload(imageCar.getImg2().getBytes(),
						ObjectUtils.asMap("public_id", imageName));
				String urlImage = (String) mapUpload.get("secure_url");
				imageCar.setImage2(urlImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (!imageCar.getImg3().isEmpty()) {
			try {
				String imageName = imageCar.getCarID().getCarID() + "3";
				cloudinary.uploader().destroy(imageName,
						ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
				Map mapUpload = cloudinary.uploader().upload(imageCar.getImg3().getBytes(),
						ObjectUtils.asMap("public_id", imageName));
				String urlImage = (String) mapUpload.get("secure_url");
				imageCar.setImage3(urlImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (!imageCar.getImg4().isEmpty()) {
			try {
				String imageName = imageCar.getCarID().getCarID() + "4";
				cloudinary.uploader().destroy(imageName,
						ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
				Map mapUpload = cloudinary.uploader().upload(imageCar.getImg4().getBytes(),
						ObjectUtils.asMap("public_id", imageName));
				String urlImage = (String) mapUpload.get("secure_url");
				imageCar.setImage4(urlImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (!imageCar.getImg5().isEmpty()) {
			try {
				String imageName = imageCar.getCarID().getCarID() + "5";
				cloudinary.uploader().destroy(imageName,
						ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
				Map mapUpload = cloudinary.uploader().upload(imageCar.getImg5().getBytes(),
						ObjectUtils.asMap("public_id", imageName));
				String urlImage = (String) mapUpload.get("secure_url");
				imageCar.setImage5(urlImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		imageCar.setCarID(car);
		imageCarRepository.save(imageCar);
		return "redirect:/admin/home-car";
	}
}
