package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;
import javax.persistence.IdClass;

@IdClass(ShipmentDetails.class)
public class ShipmentDetails {

    @Id
    @Column(name = "supplierID")
    private String supplierID;
    @Id
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "unitPrice")
    private Timestamp unitPrice;
    @Column(name = "quantity")
    private Timestamp quantity;

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Timestamp unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Timestamp getQuantity() {
        return quantity;
    }

    public void setQuantity(Timestamp quantity) {
        this.quantity = quantity;
    }
}
