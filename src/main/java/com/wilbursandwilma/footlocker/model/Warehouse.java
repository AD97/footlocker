package com.wilbursandwilma.footlocker.model;
import javax.persistence.Column;
import javax.persistence.Id;

public class Warehouse {
    @Id
    @Column(name = "warehouseID")
    private String warehouseID;
    @Column(name = "zipCode")
    private Number zipCode;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "addressLine1")
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;
    @Column(name = "contactNo")
    private Number contactNo;

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Number getZipCode() {
        return zipCode;
    }

    public void setZipCode(Number zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Number getContactNo() {
        return contactNo;
    }

    public void setContactNo(Number contactNo) {
        this.contactNo = contactNo;
    }
}
