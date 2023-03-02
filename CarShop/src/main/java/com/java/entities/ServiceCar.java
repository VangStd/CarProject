package com.java.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "ServiceCar")
public class ServiceCar implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ServiceID")
	private Long serviceID;
	@Basic(optional = false)
	@NotNull
	// @Size(min = 1, max = 255)
	@Column(name = "ServiceName")
	@Pattern(regexp = "SVC[0-9]{2,3}", message = "Service name must begin with 'SVC' and after it's number 01-999 ")
	private String serviceName;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@NotNull(message = "Please enter price")
	@Column(name = "Price")
	@Range(min = 50, max = 2000, message = "Price from 50$ to 2000$ ")
	private Double price;
	@Basic(optional = false)
	@Length(min = 10, max = 200, message = "Description from 10 to 200 ")
	@Column(name = "ServiceDescription")
	private String serviceDescription;

	@OneToMany(cascade = {CascadeType.ALL,CascadeType.REMOVE}, mappedBy = "serviceID")
	private Collection<OrderServiceDetail> orderServiceDetailCollection;

	public ServiceCar() {
	}

	public ServiceCar(Long serviceID) {
		this.serviceID = serviceID;
	}

	public ServiceCar(Long serviceID, String serviceName, Double price, String serviceDescription) {
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.price = price;
		this.serviceDescription = serviceDescription;
	}

	public Long getServiceID() {
		return serviceID;
	}

	public void setServiceID(Long serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	
	public Collection<OrderServiceDetail> getOrderServiceDetailCollection() {
		return orderServiceDetailCollection;
	}

	public void setOrderServiceDetailCollection(Collection<OrderServiceDetail> orderServiceDetailCollection) {
		this.orderServiceDetailCollection = orderServiceDetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (serviceID != null ? serviceID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ServiceCar)) {
			return false;
		}
		ServiceCar other = (ServiceCar) object;
		if ((this.serviceID == null && other.serviceID != null)
				|| (this.serviceID != null && !this.serviceID.equals(other.serviceID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.java.entities.ServiceCar[ serviceID=" + serviceID + " ]";
	}

}
