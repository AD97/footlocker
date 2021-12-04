package com.wilbursandwilma.footlocker.model;

public class Member {

    private String membershipID;
    private Timestamp dateofAssociation;
    private String expiryDate;
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
