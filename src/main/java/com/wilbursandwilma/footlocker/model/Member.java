package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Member {

    @Id
    @Column(name = "membershipID")
    private String membershipID;
    @Column(name = "dateofAssociation")
    private Timestamp dateofAssociation;
    @Column(name = "expiryDate")
    private String expiryDate;
    @Column(name = "totPoints")
    private Number totPoints;
    
    public String getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }

    public Timestamp getDateofAssociation() {
        return dateofAssociation;
    }

    public void setDateofAssociation(Timestamp dateofAssociation) {
        this.dateofAssociation = dateofAssociation;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Number getTotPoints() {
        return totPoints;
    }

    public void setTotPoints(Number totPoints) {
        this.totPoints = totPoints;
    }



}
