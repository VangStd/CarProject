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
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "ImageCar")
public class ImageCar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ImageDefault")
    private String imageDefault;
    @Column(name = "Image1")
    private String image1;
    @Column(name = "Image2")
    private String image2;
    @Column(name = "Image3")
    private String image3;
    @Column(name = "Image4")
    private String image4;
    @Column(name = "Image5")
    private String image5;
    @Valid
    @JoinColumn(name = "CarID", referencedColumnName = "CarID")
    @ManyToOne(optional = false)
    private Car carID;

    @Transient
    private MultipartFile img1;
    @Transient
    private MultipartFile img2;
    @Transient
    private MultipartFile img3;
    @Transient
    private MultipartFile img4;
    @Transient
    private MultipartFile img5;
    
    
    public ImageCar() {
    }

    public ImageCar(Integer id) {
        this.id = id;
    }

    public ImageCar(Integer id, String imageDefault) {
        this.id = id;
        this.imageDefault = imageDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(String imageDefault) {
        this.imageDefault = imageDefault;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public Car getCarID() {
        return carID;
    }

    public void setCarID(Car carID) {
        this.carID = carID;
    }
    
    

    public MultipartFile getImg1() {
		return img1;
	}

	public void setImg1(MultipartFile img1) {
		this.img1 = img1;
	}

	public MultipartFile getImg2() {
		return img2;
	}

	public void setImg2(MultipartFile img2) {
		this.img2 = img2;
	}

	public MultipartFile getImg3() {
		return img3;
	}

	public void setImg3(MultipartFile img3) {
		this.img3 = img3;
	}

	public MultipartFile getImg4() {
		return img4;
	}

	public void setImg4(MultipartFile img4) {
		this.img4 = img4;
	}

	public MultipartFile getImg5() {
		return img5;
	}

	public void setImg5(MultipartFile img5) {
		this.img5 = img5;
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
        if (!(object instanceof ImageCar)) {
            return false;
        }
        ImageCar other = (ImageCar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.entities.ImageCar[ id=" + id + " ]";
    }
    
}
