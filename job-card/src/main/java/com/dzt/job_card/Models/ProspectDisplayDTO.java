package com.dzt.job_card.Models;

import java.util.Date;
import java.util.List;

public class ProspectDisplayDTO {

    private int jobId;
    private int prospectId;
    private int activeJobId;
    private String clientFirstName;
    private String clientLastName;
    private String jobAddress;
    private String jobTown;
    private String jobCounty;
    private Date intakeDate;
    private String jobType;

    public ProspectDisplayDTO() {}

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getProspectId() {
        return prospectId;
    }

    public void setProspectId(int prospectId) {
        this.prospectId = prospectId;
    }

    public int getActiveJobId() {
        return activeJobId;
    }

    public void setActiveJobId(int activeJobId) {
        this.activeJobId = activeJobId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getJobTown() {
        return jobTown;
    }

    public void setJobTown(String jobTown) {
        this.jobTown = jobTown;
    }

    public String getJobCounty() {
        return jobCounty;
    }

    public void setJobCounty(String jobCounty) {
        this.jobCounty = jobCounty;
    }

    public Date getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(Date intakeDate) {
        this.intakeDate = intakeDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
