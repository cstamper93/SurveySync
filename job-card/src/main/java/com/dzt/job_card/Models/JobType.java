package com.dzt.job_card.Models;

public class JobType {

    private int jobTypeId;
    private int jobId;
    private String jobType; // division, eps, fs, alta, recomb, etc etc
    private double price;
    private String typeDescription;
    private int estimatedFieldDays;

    public JobType(){}

    public int getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(int jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public int getEstimatedFieldDays() {
        return estimatedFieldDays;
    }

    public void setEstimatedFieldDays(int estimatedFieldDays) {
        this.estimatedFieldDays = estimatedFieldDays;
    }
}
