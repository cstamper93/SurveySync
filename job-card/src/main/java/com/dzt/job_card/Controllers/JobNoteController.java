package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.JobNoteDao;
import com.dzt.job_card.Models.JobNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobNoteController {

    @Autowired
    JobNoteDao jobNoteDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/job-note")
    public JobNote createJobNote(@RequestBody JobNote jobNote) {
        return jobNoteDao.createJobNote(jobNote);
    }

    @GetMapping("/job-note-by-id/{id}")
    public JobNote getNoteById(@PathVariable int id) {
        return jobNoteDao.getNoteById(id);
    }

    @GetMapping("/job-notes-by-job/{id}")
    public List<JobNote> getNotesByJob(@PathVariable int id) {
        return jobNoteDao.getAllNotesByJob(id);
    }

    @PutMapping("/job-note")
    public JobNote editNote(@RequestBody JobNote jobNote) {
        return jobNoteDao.editNote(jobNote);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/job-note/{id}")
    public boolean deleteNote(@PathVariable int id) {
        return jobNoteDao.deleteNote(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/job-notes/{id}")
    public int deleteNotesByJob(@PathVariable int id) {
        return jobNoteDao.deleteNotesByJob(id);
    }

}
