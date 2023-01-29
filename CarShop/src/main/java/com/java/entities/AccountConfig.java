package com.java.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "AccountConfig")

public class AccountConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Long id;
	@Basic(optional = false)
	@Column(name = "Firstname")
	@Length(min = 2,max = 10,message = "Firstname must from 2 to 10 character")
	private String firstname;
	@Basic(optional = false)
	@Column(name = "Lastname")
	@Length(min = 2,max = 10,message = "Firstname must from 2 to 10 character")
	private String lastname;
	@Basic(optional = false)
	@Column(name = "Phone")
	@Pattern(regexp = "0[0-9]{9,11}",message = "Phone must begin 0 and from 10 to 13 number")
	private String phone;
	@Column(name = "Address")
	private String address;
	@Column(name = "Sex")
	private Integer sex;
	@Valid
	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
	@ManyToOne(optional = false)
	private Accounts accountID;

	public AccountConfig() {
	}

	public AccountConfig(Long id) {
		this.id = id;
	}

	public AccountConfig(Long id, String firstname, String lastname, String phone) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Accounts getAccountID() {
		return accountID;
	}

	public void setAccountID(Accounts accountID) {
		this.accountID = accountID;
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
		if (!(object instanceof AccountConfig)) {
			return false;
		}
		AccountConfig other = (AccountConfig) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AccountConfig [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", address=" + address + ", sex=" + sex +"account"+ accountID.toString() +"]";
	}



}
