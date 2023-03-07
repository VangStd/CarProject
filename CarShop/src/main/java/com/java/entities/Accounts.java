package com.java.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "Accounts")
public class Accounts implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "AccountID")
	private Long accountID;
	@Basic(optional = false)
	@Column(name = "Username")
	@Length(min = 6, max = 15, message = "Username must from 6 to 15 character")
	private String username;
	@Basic(optional = false)
	@Column(name = "Password")
	// @Min(value = 6,message = "Password must than 6 character")
	@Length(min = 6, message = "Password must than 6 character")
	private String password;
	@Basic(optional = false)
	@Column(name = "Email")
	@Email(message = "Email invalid (must have @ )")
	private String email;
	@Basic(optional = false)
	@Column(name = "Roles")
	private String roles;
	@Basic(optional = false)
	@Column(name = "Status")
	private int status;

	@Transient
	private String confirmpass;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "accounts")
	private TechnicianDetail technicianDetail;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "accountID")
	private Collection<AccountConfig> accountConfigCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "technicianID")
	private Collection<ProcessBookingService> processBookingServiceCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
	private Collection<OrderService> orderServiceCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "technicianSender")
	private Collection<RequestChangeTechnician> requestChangeTechnicianCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "technicianReceiver")
	private Collection<RequestChangeTechnician> requestChangeTechnicianCollection1;

	public List<GrantedAuthority> getListGrant() {
		String str[] = roles.split(",");
		List<GrantedAuthority> listGrant = new ArrayList<GrantedAuthority>();
		for (String string : str) {
			listGrant.add(new SimpleGrantedAuthority(string));
		}
		return listGrant;
	}

	public Accounts() {
	}

	public Accounts(Long accountID) {
		this.accountID = accountID;
	}

	public Accounts(Long accountID, String username, String password, String email, String roles, int status) {
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.status = status;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public Collection<AccountConfig> getAccountConfigCollection() {
		return accountConfigCollection;
	}

	public void setAccountConfigCollection(Collection<AccountConfig> accountConfigCollection) {
		this.accountConfigCollection = accountConfigCollection;
	}

	public TechnicianDetail getTechnicianDetail() {
		return technicianDetail;
	}

	public void setTechnicianDetail(TechnicianDetail technicianDetail) {
		this.technicianDetail = technicianDetail;
	}

	public Collection<ProcessBookingService> getProcessBookingServiceCollection() {
		return processBookingServiceCollection;
	}

	public void setProcessBookingServiceCollection(Collection<ProcessBookingService> processBookingServiceCollection) {
		this.processBookingServiceCollection = processBookingServiceCollection;
	}

	public Collection<OrderService> getOrderServiceCollection() {
		return orderServiceCollection;
	}

	public void setOrderServiceCollection(Collection<OrderService> orderServiceCollection) {
		this.orderServiceCollection = orderServiceCollection;
	}
	
	public Collection<RequestChangeTechnician> getRequestChangeTechnicianCollection() {
		return requestChangeTechnicianCollection;
	}

	public void setRequestChangeTechnicianCollection(
			Collection<RequestChangeTechnician> requestChangeTechnicianCollection) {
		this.requestChangeTechnicianCollection = requestChangeTechnicianCollection;
	}

	public Collection<RequestChangeTechnician> getRequestChangeTechnicianCollection1() {
		return requestChangeTechnicianCollection1;
	}

	public void setRequestChangeTechnicianCollection1(
			Collection<RequestChangeTechnician> requestChangeTechnicianCollection1) {
		this.requestChangeTechnicianCollection1 = requestChangeTechnicianCollection1;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (accountID != null ? accountID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Accounts)) {
			return false;
		}
		Accounts other = (Accounts) object;
		if ((this.accountID == null && other.accountID != null)
				|| (this.accountID != null && !this.accountID.equals(other.accountID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Accounts [accountID=" + accountID + ", username=" + username + ", password=" + password + ", email="
				+ email + ", roles=" + roles + ", status=" + status + ", confirmpass=" + confirmpass
				+ ", accountConfigCollection=" + accountConfigCollection + "]";
	}

}
