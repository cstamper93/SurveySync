package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobNote;

import java.util.List;

public interface JobNoteDao {

    JobNote createJobNote(JobNote jobNote);

    JobNote getNoteById(int id);

    List<JobNote> getAllNotesByJob(int jobId);

    JobNote editNote(JobNote jobNote);

    boolean deleteNote(int id);

    boolean deleteNotesByJob(int jobId);

}
