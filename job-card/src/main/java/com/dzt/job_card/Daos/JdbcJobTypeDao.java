package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobType;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcJobTypeDao implements JobTypeDao {

    private final JdbcTemplate template;

    public JdbcJobTypeDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public JobType addJobType(JobType jobType) {
        String sql = "INSERT INTO job_type (job_id, job_type, price, type_description, " +
                "estimated_field_days VALUES(?, ?, ?, ?, ?) " +
                "RETURNING job_type_id;";
        Integer newId = template.queryForObject(sql, Integer.class, jobType.getJobId(), jobType.getJobType(),
                jobType.getPrice(), jobType.getTypeDescription(), jobType.getEstimatedFieldHours());
        if(newId == null) {
            throw new NullPointerException("New job type was not created :0");
        } else {
            return getJobTypeById(jobType.getJobTypeId());
        }
    }

    @Override
    public JobType getJobTypeById(int id) {
        JobType jobType = new JobType();
        String sql = "SELECT * FROM job_type WHERE job_type_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if(result.next()) {
            jobType = mapRowToJobType(result);
        }
        return jobType;
    }

    @Override
    public List<JobType> getJobTypesByJob(int jobId) {
        List<JobType> jobTypes = new ArrayList<>();
        String sql = "SELECT * FROM job_type WHERE job_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, jobId);
        while(results.next()) {
            jobTypes.add(mapRowToJobType(results));
        }
        return jobTypes;
    }

    @Override
    public JobType editJobType(JobType jobType) {
        String sql = "UPDATE job_type SET job_type_id = ?, job_id = ?, job_type = ?, price = ?, " +
                "type_description = ?, estimated_field_days = ?;";
        template.update(sql, jobType.getJobTypeId(), jobType.getJobId(), jobType.getJobType(), jobType.getPrice(),
                jobType.getTypeDescription(), jobType.getEstimatedFieldHours());
        return getJobTypeById(jobType.getJobTypeId());
    }

    @Override
    public boolean deleteJobType(int id) {
        boolean success = false;
        String sql = "DELETE FROM job_type WHERE job_type_id = ?;";
        int linesUpdated = template.update(sql, id);
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public void deleteJobTypesByJob(int jobId) {
        String sql = "DELETE FROM job_type WHERE job_id = ?;";
        template.update(sql, jobId);
    }

    private JobType mapRowToJobType(SqlRowSet rs) {
        JobType jobType = new JobType();
        jobType.setJobTypeId(rs.getInt("job_type_id"));
        jobType.setJobId(rs.getInt("job_id"));
        jobType.setJobType(rs.getString("job_type"));
        jobType.setPrice(rs.getDouble("price"));
        jobType.setTypeDescription(rs.getString("type_description"));
        jobType.setEstimatedFieldHours(rs.getInt("estimated_field_days"));
        return jobType;
    }
}
