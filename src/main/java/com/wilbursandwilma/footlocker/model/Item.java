package com.wilbursandwilma.footlocker.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "itemID")
    private String itemID;
    @Column(name = "modelno")
    private String modelNo;
    @Column(name = "supplierID")
    private String supplierID;



    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }


    public String getModelno() {
        return modelNo;
    }

    public void setModelno(String modelno) {
        this.modelNo = modelno;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public Item (){}

    public Item(String itemID, String modelno, String supplierID) {
        this.itemID = itemID;
        this.modelNo = modelno;
        this.supplierID = supplierID;
    }


}
