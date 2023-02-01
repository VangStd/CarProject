package com.java.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CarDetail")
public class CarDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "Color")
	private String color;
	@Basic(optional = false)
	@Column(name = "DateBuy")
	@Temporal(TemporalType.DATE)
	private Date dateBuy;
	@Basic(optional = false)
	@Column(name = "Fuel")
	private String fuel;
	@Basic(optional = false)
	@Column(name = "Tranmission")
	private String tranmission;
	@Column(name = "Feature")
	private String feature;
	@JoinColumn(name = "CarID", referencedColumnName = "CarID")
	@ManyToOne(optional = false)
	private Car carID;

	public CarDetail() {
	}

	public CarDetail(Integer id) {
		this.id = id;
	}

	public CarDetail(Integer id, String color, Date dateBuy, String fuel, String tranmission) {
		this.id = id;
		this.color = color;
		this.dateBuy = dateBuy;
		this.fuel = fuel;
		this.tranmission = tranmission;
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

	public Date getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(Date dateBuy) {
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

	public Car getCarID() {
		return carID;
	}

	public void setCarID(Car carID) {
		this.carID = carID;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CarDetail)) {
			return false;
		}
		CarDetail other = (CarDetail) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CarDetail [id=" + id + ", color=" + color + ", dateBuy=" + dateBuy + ", fuel=" + fuel + ", tranmission="
				+ tranmission + ", feature=" + feature + "]";
	}

}
