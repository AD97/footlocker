package com.wilbursandwilma.footlocker.model;

public class Customer {
    private String custID;
    private String dob;
    private String email;
    private String phoneNo;
    private Character gender;
    private String fName;
    private String mInitial;
    private String lName;

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmInitial() {
        return mInitial;
    }

    public void setmInitial(String mInitial) {
        this.mInitial = mInitial;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Customer (){}

    public Customer(String custID, String dob, String email, String phoneNo, Character gender, String fName, String mInitial, String lName){
        this.custID = custID;
        this.dob = dob;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.fName = fName;
        this.mInitial = mInitial;
        this.lName = lName;
    }



//    @Override
//    public String toString() {
//        return "Customer [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
//    }

}
