/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "OrderService")
public class OrderService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "OrderID")
	private Integer orderID;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "BookDate")
	private String bookDate;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "OrderDate")
	private String orderDate;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "Note")
	private String note;
	@Column(name = "EmailOnInvoice")
	private String emailOnInvoice;
	@Column(name = "phoneOnInvoice")
	private String PhoneOnInvoice;
	@Column(name = "NameOnInvoice")
	private String nameOnInvoice;
	@Column(name = "Status")
	private String status;

	@JoinColumn(name = "CustomerID", referencedColumnName = "AccountID")
	@ManyToOne(optional = false)
	private Accounts customerID;

	@OneToMany(cascade = { CascadeType.ALL, CascadeType.REMOVE }, mappedBy = "orderID", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private Collection<OrderServiceDetail> orderServiceDetailCollection;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "orderService")
	private ProcessBookingService processBookingService;

	public OrderService() {
	}

	public OrderService(Integer orderID) {
		this.orderID = orderID;
	}

	public OrderService(Integer orderID, String bookDate, String orderDate, String note) {
		this.orderID = orderID;
		this.bookDate = bookDate;
		this.orderDate = orderDate;
		this.note = note;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Accounts getCustomerID() {
		return customerID;
	}

	public String getEmailOnInvoice() {
		return emailOnInvoice;
	}

	public void setEmailOnInvoice(String emailOnInvoice) {
		this.emailOnInvoice = emailOnInvoice;
	}

	public String getPhoneOnInvoice() {
		return PhoneOnInvoice;
	}

	public void setPhoneOnInvoice(String phoneOnInvoice) {
		PhoneOnInvoice = phoneOnInvoice;
	}

	public String getNameOnInvoice() {
		return nameOnInvoice;
	}

	public void setNameOnInvoice(String nameOnInvoice) {
		this.nameOnInvoice = nameOnInvoice;
	}

	public void setCustomerID(Accounts customerID) {
		this.customerID = customerID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlTransient
	public Collection<OrderServiceDetail> getOrderServiceDetailCollection() {
		return orderServiceDetailCollection;
	}

	public void setOrderServiceDetailCollection(Collection<OrderServiceDetail> orderServiceDetailCollection) {
		this.orderServiceDetailCollection = orderServiceDetailCollection;
	}

	public ProcessBookingService getProcessBookingService() {
		return processBookingService;
	}

	public void setProcessBookingService(ProcessBookingService processBookingService) {
		this.processBookingService = processBookingService;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (orderID != null ? orderID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OrderService)) {
			return false;
		}
		OrderService other = (OrderService) object;
		if ((this.orderID == null && other.orderID != null)
				|| (this.orderID != null && !this.orderID.equals(other.orderID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.java.entities.OrderService[ orderID=" + orderID + " ]";
	}

}
