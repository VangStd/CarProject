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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "TypeCar")
public class TypeCar implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "TypeID")
	private Integer typeID;
	@Basic(optional = false)
	@Column(name = "TypeName")
	@Length(min = 2, max = 20, message = "TypeName must have from 2 to 20 character")
	private String typeName;
	@Basic(optional = false)
	@Column(name = "TypeDescription")
	@Length(min = 2, max = 40, message = "TypeName must have from 2 to 40 character")
	private String typeDescription;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
	private Collection<Car> carCollection;

	public TypeCar() {
	}

	public TypeCar(Integer typeID) {
		this.typeID = typeID;
	}

	public TypeCar(Integer typeID, String typeName, String typeDescription) {
		this.typeID = typeID;
		this.typeName = typeName;
		this.typeDescription = typeDescription;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
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
		hash += (typeID != null ? typeID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TypeCar)) {
			return false;
		}
		TypeCar other = (TypeCar) object;
		if ((this.typeID == null && other.typeID != null)
				|| (this.typeID != null && !this.typeID.equals(other.typeID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.java.entities.TypeCar[ typeID=" + typeID + " ]";
	}

}
