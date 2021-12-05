package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Payments {

    @Id
    @Column(name = "paymentID")
    private String paymentID;
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Column(name = "subTotal")
    private Number subTotal;
    @Column(name = "timeStamp")
    private Number timeStamp;
    @Column(name = "deliveryCost")
    private Number deliveryCost;
    @Column(name = "tax")
    private Number tax;
    @Column(name = "invoiceID")
    private String invoiceID;

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Number getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Number subTotal) {
        this.subTotal = subTotal;
    }

    public Number getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Number timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Number getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Number deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Number getTax() {
        return tax;
    }

    public void setTax(Number tax) {
        this.tax = tax;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
}
