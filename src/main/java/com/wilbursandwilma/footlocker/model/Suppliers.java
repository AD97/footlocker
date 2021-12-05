package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

public class Suppliers {

    @Id
    @Column(name = "supplierID")
    private String supplierID;
    @Column(name = "supplierName")
    private String supplierName;
    @Column(name = "contactFirstName")
    private String contactFirstName;
    @Column(name = "contactLastName")
    private String contactLastName;
    @Column(name = "contractStartDate")
    private Date contractStartDate;
    @Column(name = "contractEndDate")
    private Date contractEndDate;

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
}
