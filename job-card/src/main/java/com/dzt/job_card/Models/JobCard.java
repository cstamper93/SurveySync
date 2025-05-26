package com.dzt.job_card.Models;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class JobCard {

    private int jobId;
    private String prospectId;
    private String activeJobId;
    private Date intakeDate;
    private LocalTime intakeTime;
    private List<Integer> clientIds; // lists will need extra data table
    private List<Integer> propIds; // change
    private int markLinesLength;
    private List<String> jobType; // change
    private String jobDescription;
    private String housePlanName;
    private String jobStatus;
    private Date completeBy;

    public JobCard() {
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getProspectId() {
        return prospectId;
    }

    public void setProspectId(String prospectId) {
        this.prospectId = prospectId;
    }

    public String getActiveJobId() {
        return activeJobId;
    }

    public void setActiveJobId(String activeJobId) {
        this.activeJobId = activeJobId;
    }

    public Date getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(Date intakeDate) {
        this.intakeDate = intakeDate;
    }

    public LocalTime getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(LocalTime intakeTime) {
        this.intakeTime = intakeTime;
    }

    public List<Integer> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<Integer> clientIds) {
        this.clientIds = clientIds;
    }

    public List<Integer> getPropIds() {
        return propIds;
    }

    public void setPropIds(List<Integer> propIds) {
        this.propIds = propIds;
    }

    public int getMarkLinesLength() {
        return markLinesLength;
    }

    public void setMarkLinesLength(int markLinesLength) {
        this.markLinesLength = markLinesLength;
    }

    public List<String> getJobType() {
        return jobType;
    }

    public void setJobType(List<String> jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getHousePlanName() {
        return housePlanName;
    }

    public void setHousePlanName(String housePlanName) {
        this.housePlanName = housePlanName;
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
}