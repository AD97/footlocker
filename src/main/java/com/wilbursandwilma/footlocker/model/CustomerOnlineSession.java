package com.wilbursandwilma.footlocker.model;

public class CustomerOnlineSession {
    private Number numberOfClicks;
    private String sessionID;
    private Timestamp startTimeStamp;
    private Timestamp endTimeStamp;

    public java.lang.Number getNumberOfClicks() {
        return numberOfClicks;
    }

    public void setNumberOfClicks(java.lang.Number numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    public java.lang.String getSessionID() {
        return sessionID;
    }

    public void setSessionID(java.lang.String sessionID) {
        this.sessionID = sessionID;
    }

    public Timestamp getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Timestamp startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public Timestamp getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(Timestamp endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }


}
