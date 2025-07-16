package com.dzt.job_card.Models;

import java.sql.Time;
import java.util.Date;

public class JobNote {

    private int noteId;
    private String noteContent;
    private int userId;
    private Date dateCreated;
    private Time timeCreated;
    private int jobId;

    public JobNote(){}

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Time getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Time timeCreated) {
        this.timeCreated = timeCreated;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
