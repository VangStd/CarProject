package com.java.dto;

public class ServiceCarDTO {

	private long id;
	private String serviceName;
	private double price;
	private String serviceDescription;

	public ServiceCarDTO(long id, String serviceName, double price, String serviceDescription) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.price = price;
		this.serviceDescription = serviceDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Override
	public String toString() {
		return "id=" + id + ", serviceName=" + serviceName + ", price=" + price + ", serviceDescription="
				+ serviceDescription;
	}

}
