package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

public class Brands {

    @Id
    @Column(name = "brandID")
    private String brandID;
    @Column(name = "brandName")
    private String brandName;
    @Column(name = "contractStartDate")
    private Date contractStartDate;
    @Column(name = "contractEndDate")
    private Date contractEndDate;
    @Column(name = "commisionPercentage")
    private Number commisionPercentage;

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public Number getCommisionPercentage() {
        return commisionPercentage;
    }

    public void setCommisionPercentage(Number commisionPercentage) {
        this.commisionPercentage = commisionPercentage;
    }
}
