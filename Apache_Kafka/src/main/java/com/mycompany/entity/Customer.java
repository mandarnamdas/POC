package com.mycompany.entity;

import java.io.Serializable;

public class Customer implements Serializable {

    private int customerId;

    private String status;

    private String startTime;

    private String endTime;

    private double timeDifference;

    public Customer() {
    }

    public Customer(int customerId, String status, String startTime, String endTime) {
        this.customerId = customerId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(double timeDifference) {
        this.timeDifference = timeDifference;
    }
}
