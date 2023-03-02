package com.java.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "TechnicianDetail")

public class TechnicianDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TechnicianID")
    private Long technicianID;
    @Column(name = "Request")
    private Integer request;
    @Column(name = "RequestProcessing")
    private Integer requestProcessing;
    @Column(name = "RequestCompleted")
    private Integer requestCompleted;
    @Column(name = "Mark")
    private Integer mark;
    @JoinColumn(name = "TechnicianID", referencedColumnName = "AccountID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Accounts accounts;

    public TechnicianDetail() {
    }

    public TechnicianDetail(Long technicianID) {
        this.technicianID = technicianID;
    }

    public Long getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(Long technicianID) {
        this.technicianID = technicianID;
    }

    public Integer getRequest() {
        return request;
    }

    public void setRequest(Integer request) {
        this.request = request;
    }

    public Integer getRequestProcessing() {
        return requestProcessing;
    }

    public void setRequestProcessing(Integer requestProcessing) {
        this.requestProcessing = requestProcessing;
    }

    public Integer getRequestCompleted() {
        return requestCompleted;
    }

    public void setRequestCompleted(Integer requestCompleted) {
        this.requestCompleted = requestCompleted;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (technicianID != null ? technicianID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TechnicianDetail)) {
            return false;
        }
        TechnicianDetail other = (TechnicianDetail) object;
        if ((this.technicianID == null && other.technicianID != null) || (this.technicianID != null && !this.technicianID.equals(other.technicianID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.entities.TechnicianDetail[ technicianID=" + technicianID + " ]";
    }
    
}
