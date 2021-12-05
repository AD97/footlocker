package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class CanSupply {

    @Id
    @Column(name = "modelNo")
    private String modelNo;
    @Column(name = "supplierID")
    private String supplierID;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
}
