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
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "BrandCar")
public class BrandCar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BrandID")
    private Integer brandID;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "BrandName")
    private String brandName;
    @Basic(optional = false)
    @Column(name = "Country")
    private String country;
    @Column(name = "HomePage")
    private String homePage;
    @Column(name = "Phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandID")
    private Collection<Car> carCollection;

    public BrandCar() {
    }

    public BrandCar(Integer brandID) {
        this.brandID = brandID;
    }

    public BrandCar(Integer brandID, String companyName, String brandName, String country) {
        this.brandID = brandID;
        this.companyName = companyName;
        this.brandName = brandName;
        this.country = country;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Car> getCarCollection() {
        return carCollection;
    }

    public void setCarCollection(Collection<Car> carCollection) {
        this.carCollection = carCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandID != null ? brandID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandCar)) {
            return false;
        }
        BrandCar other = (BrandCar) object;
        if ((this.brandID == null && other.brandID != null) || (this.brandID != null && !this.brandID.equals(other.brandID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.entities.BrandCar[ brandID=" + brandID + " ]";
    }
    
}
