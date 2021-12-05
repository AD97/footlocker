package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

public class Shipments {

    @Id
    @Column(name = "shipmentID")
    private String shipmentID;
    @Column(name = "shipmentStatus")
    private String shipmentStatus;
    @Column(name = "shippingAddress")
    private String shippingAddress;
    @Column(name = "dateOfShipping")
    private Date dateOfShipping;
    @Column(name = "dateOfDelivery")
    private Date dateOfDelivery;

    public String getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(String shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getDateOfShipping() {
        return dateOfShipping;
    }

    public void setDateOfShipping(Date dateOfShipping) {
        this.dateOfShipping = dateOfShipping;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }
}
