package com.java.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CarID")
    private Long carID;
    @Basic(optional = false)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "Seat")
    private int seat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @Column(name = "Sale")
    private int sale;
    @Column(name = "QuantityOnInVoice")
    private Integer quantityOnInVoice;
    @Column(name = "Status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID")
    private Collection<ImageCar> imageCarCollection;
    @JoinColumn(name = "BrandID", referencedColumnName = "BrandID")
    @ManyToOne(optional = false)
    private BrandCar brandID;
    @JoinColumn(name = "TypeID", referencedColumnName = "TypeID")
    @ManyToOne(optional = false)
    private TypeCar typeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID")
    private Collection<CarDetail> carDetailCollection;

    public Car() {
    }

    public Car(Long carID) {
        this.carID = carID;
    }

    public Car(Long carID, String productName, int seat, BigDecimal price, int quantity, String image, int sale) {
        this.carID = carID;
        this.productName = productName;
        this.seat = seat;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.sale = sale;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Integer getQuantityOnInVoice() {
        return quantityOnInVoice;
    }

    public void setQuantityOnInVoice(Integer quantityOnInVoice) {
        this.quantityOnInVoice = quantityOnInVoice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<ImageCar> getImageCarCollection() {
        return imageCarCollection;
    }

    public void setImageCarCollection(Collection<ImageCar> imageCarCollection) {
        this.imageCarCollection = imageCarCollection;
    }

    public BrandCar getBrandID() {
        return brandID;
    }

    public void setBrandID(BrandCar brandID) {
        this.brandID = brandID;
    }

    public TypeCar getTypeID() {
        return typeID;
    }

    public void setTypeID(TypeCar typeID) {
        this.typeID = typeID;
    }

    @XmlTransient
    public Collection<CarDetail> getCarDetailCollection() {
        return carDetailCollection;
    }

    public void setCarDetailCollection(Collection<CarDetail> carDetailCollection) {
        this.carDetailCollection = carDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carID != null ? carID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carID == null && other.carID != null) || (this.carID != null && !this.carID.equals(other.carID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.entities.Car[ carID=" + carID + " ]";
    }
    
}
