package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobNote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcJobNoteDao implements JobNoteDao {

    private final JdbcTemplate template;

    public JdbcJobNoteDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public JobNote createJobNote(JobNote jobNote) {
        JobNote newJobNote = new JobNote();
        String sql = "INSERT INTO job_note (note_content, user_id, date_created, time_created, job_id) " +
                "VALUES(?, ?, ?, ?, ?) RETURNING job_note_id;";
        Integer newId = template.queryForObject(sql, Integer.class, jobNote.getNoteContent(), jobNote.getUserId(),
                jobNote.getDateCreated(), jobNote.getTimeCreated(), jobNote.getJobId());
        if(newId == null) {
            throw new NullPointerException("Couldn't create new note for you...so, so sorry");
        } else {
            return getNoteById(newId);
        }
    }

    @Override
    public JobNote getNoteById(int id) {
        JobNote note = new JobNote();
        String sql = "SELECT * FROM job_note WHERE job_note_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if(result.next()) {
            note = mapRowToJobNote(result);
        }
        return note;
    }

    @Override
    public List<JobNote> getAllNotesByJob(int jobId) {
        return null;
    }

    @Override
    public JobNote editNote(JobNote jobNote) {
        return null;
    }

    @Override
    public boolean deleteNote(int id) {
        return false;
    }

    @Override
    public boolean deleteNotesByJob(int jobId) {
        return false;
    }

    private JobNote mapRowToJobNote(SqlRowSet rs) {
        JobNote note = new JobNote();
        note.setNoteId(rs.getInt("job_note_id"));
        note.setNoteContent(rs.getString("note_content"));
        note.setUserId(rs.getInt("user_id"));
        note.setDateCreated(rs.getDate("date_created"));
        note.setTimeCreated(rs.getTime("time_created"));
        note.setJobId(rs.getInt("job_id"));
        return note;
    }
}
