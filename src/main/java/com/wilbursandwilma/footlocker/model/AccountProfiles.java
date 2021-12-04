package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;


public class AccountProfiles {

    @Id
    @Column(name = "profileID")
    private String profileID;
    @Column(name = "custID")
    private String custID;
    @Column(name = "campaignID")
    private String campaignID;
    @Column(name = "userName")
    private String  userName;
    @Column(name = "accPassword")
    private String accPassword;

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(String campaignID) {
        this.campaignID = campaignID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }
}
