package com.dzt.job_card.Models;

import java.util.Date;

public class JobCard {

    private int id;
    private int jobNumber;
    private Date intakeDate;
    private String clientName;
    private String phoneNumber; // Change phone number data types?
    private String altPhoneNumber;
    private String billingAddress;
    private String billingTown;
    private String billingState;
    private String billingZip;
    private String clientEmail;
    private String altEmail;
    private String propertyOwnerFirst;
    private String propertyOwnerLast;
    private String jobAddress;
    private String jobTown;
    private String jobState;
    private String jobZip;
    private String deedBook; // since there can be letters in them
    private String deedPage;
    private String mapBook;
    private String mapPage;
    private int parcelPerimeter; // stores whole numbers from -2,147,483,648 to 2,147,483,647
    private int newLinesLength; // if jobType is a division
    private String jobType;
    private String jobDescription;
    private String jobStatus;
    private Date completeBy;

    // add: acreage, perimeter, new line length

    public JobCard(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAltPhoneNumber() {
        return altPhoneNumber;
    }

    public void setAltPhoneNumber(String altPhoneNumber) {
        this.altPhoneNumber = altPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getCompleteBy() {
        return completeBy;
    }

    public void setCompleteBy(Date completeBy) {
        this.completeBy = completeBy;
    }

    public Date getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(Date intakeDate) {
        this.intakeDate = intakeDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingTown() {
        return billingTown;
    }

    public void setBillingTown(String billingTown) {
        this.billingTown = billingTown;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getPropertyOwnerFirst() {
        return propertyOwnerFirst;
    }

    public void setPropertyOwnerFirst(String propertyOwnerFirst) {
        this.propertyOwnerFirst = propertyOwnerFirst;
    }

    public String getPropertyOwnerLast() {
        return propertyOwnerLast;
    }

    public void setPropertyOwnerLast(String propertyOwnerLast) {
        this.propertyOwnerLast = propertyOwnerLast;
    }

    public String getJobTown() {
        return jobTown;
    }

    public void setJobTown(String jobTown) {
        this.jobTown = jobTown;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public String getJobZip() {
        return jobZip;
    }

    public void setJobZip(String jobZip) {
        this.jobZip = jobZip;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
