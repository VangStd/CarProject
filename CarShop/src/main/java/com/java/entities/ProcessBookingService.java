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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ProcessBookingService")

public class ProcessBookingService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderID")
    private Integer orderID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReceivedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "TechnicianID", referencedColumnName = "AccountID")
    @ManyToOne(optional = false)
    private Accounts technicianID;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrderService orderService;

    public ProcessBookingService() {
    }

    public ProcessBookingService(Integer orderID) {
        this.orderID = orderID;
    }

    public ProcessBookingService(Integer orderID, Date receivedDate, String status) {
        this.orderID = orderID;
        this.receivedDate = receivedDate;
        this.status = status;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Accounts getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(Accounts technicianID) {
        this.technicianID = technicianID;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
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
        if (!(object instanceof ProcessBookingService)) {
            return false;
        }
        ProcessBookingService other = (ProcessBookingService) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.entities.ProcessBookingService[ orderID=" + orderID + " ]";
    }
    
}
