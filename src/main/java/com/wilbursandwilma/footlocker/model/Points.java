package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

import java.sql.Timestamp;

@IdClass(Points.class)
public class Points {

    @Id
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Id
    @Column(name = "membershipNumber")
    private Number membershipNumber;
    @Column(name = "activity")
    private String activity;
    @Column(name = "points")
    private Number points;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Number getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(Number membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Number getPoints() {
        return points;
    }

    public void setPoints(Number points) {
        this.points = points;
    }



}
