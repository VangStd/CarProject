package com.java.dto;

import java.util.Date;

public class CarDetailDTO {
	private Integer id;
	private String color;
	private String dateBuy;
	private String fuel;
	private String tranmission;
	private String feature;
	private long carid;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(String dateBuy) {
		this.dateBuy = dateBuy;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getTranmission() {
		return tranmission;
	}

	public void setTranmission(String tranmission) {
		this.tranmission = tranmission;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public long getCarid() {
		return carid;
	}

	public void setCarid(long carid) {
		this.carid = carid;
	}

	@Override
	public String toString() {
		return "id=" + id + ", color=" + color + ", dateBuy=" + dateBuy + ", fuel=" + fuel + ", tranmission="
				+ tranmission + ", feature=" + feature + ", carid=" + carid + "";
	}

}
