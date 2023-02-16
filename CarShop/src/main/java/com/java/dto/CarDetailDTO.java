package com.java.dto;

import java.util.Date;

public class CarDetailDTO {
	Integer id;
	String color;
	String dateBuy;
	String fuel;
	String tranmission;
	String feature;
	long carid;

	public CarDetailDTO(Integer id, String color, String dateBuy, String fuel, String tranmission, String feature,
			long carid) {
		super();
		this.id = id;
		this.color = color;
		this.dateBuy = dateBuy;
		this.fuel = fuel;
		this.tranmission = tranmission;
		this.feature = feature;
		this.carid = carid;
	}

	@Override
	public String toString() {
		return "id=" + id + ", color=" + color + ", dateBuy=" + dateBuy + ", fuel=" + fuel + ", tranmission="
				+ tranmission + ", feature=" + feature + ", carid=" + carid + "";
	}

}
