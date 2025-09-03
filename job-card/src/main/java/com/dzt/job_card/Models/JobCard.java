package com.dzt.job_card.Models;

import java.sql.Time;
import java.util.Date;

public class JobCard {

    private int jobId;
    private int prospectId;
    private String activeJobId;
    private int billingClientId;
    private Date intakeDate;
    private Time intakeTime;
    private int markLinesLength;
    private String jobDescription;
    private String housePlanName;
    private String jobStatus;
    private Date readyDate;
    private Date completeByDate;
    private Date contractSentDate;
    private boolean contractSigned;
    private Date contractSignedDate;
    private boolean lettersSent;
    private Date lettersSentDate;
    private boolean isPlotted;
    private String plottedBy;

    public JobCard() {
        this.jobStatus = "needs research";
        this.contractSigned = false;
        this.lettersSent = false;
        this.isPlotted = false;
    }

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

    public String getActiveJobId() {
        return activeJobId;
    }

    public void setActiveJobId(String activeJobId) {
        this.activeJobId = activeJobId;
    }

    public int getBillingClientId() {
        return billingClientId;
    }

    public void setBillingClientId(int billingClientId) {
        this.billingClientId = billingClientId;
    }

    public Date getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(Date intakeDate) {
        this.intakeDate = intakeDate;
    }

    public Time getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(Time intakeTime) {
        this.intakeTime = intakeTime;
    }

    public int getMarkLinesLength() {
        return markLinesLength;
    }

    public void setMarkLinesLength(int markLinesLength) {
        this.markLinesLength = markLinesLength;
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

    public Date getCompleteByDate() {
        return completeByDate;
    }

    public void setCompleteByDate(Date completeByDate) {
        this.completeByDate = completeByDate;
    }

    public Date getContractSentDate() {
        return contractSentDate;
    }

    public void setContractSentDate(Date contractSentDate) {
        this.contractSentDate = contractSentDate;
    }

    public Date getReadyDate() {
        return readyDate;
    }

    public void setReadyDate(Date readyDate) {
        this.readyDate = readyDate;
    }

    public boolean isContractSigned() {
        return contractSigned;
    }

    public void setContractSigned(boolean contractSigned) {
        this.contractSigned = contractSigned;
    }

    public Date getContractSignedDate() {
        return contractSignedDate;
    }

    public void setContractSignedDate(Date contractSignedDate) {
        this.contractSignedDate = contractSignedDate;
    }

    public boolean isLettersSent() {
        return lettersSent;
    }

    public void setLettersSent(boolean lettersSent) {
        this.lettersSent = lettersSent;
    }

    public Date getLettersSentDate() {
        return lettersSentDate;
    }

    public void setLettersSentDate(Date lettersSentDate) {
        this.lettersSentDate = lettersSentDate;
    }

    public boolean isPlotted() {
        return isPlotted;
    }

    public void setPlotted(boolean plotted) {
        isPlotted = plotted;
    }

    public String getPlottedBy() {
        return plottedBy;
    }

    public void setPlottedBy(String plottedBy) {
        this.plottedBy = plottedBy;
    }
}