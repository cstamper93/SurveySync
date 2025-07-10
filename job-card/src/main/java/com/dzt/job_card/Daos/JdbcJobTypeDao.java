package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobType;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcJobTypeDao implements JobTypeDao {

    private final JdbcTemplate template;

    public JdbcJobTypeDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public JobType addJobType(JobType jobType) {
        return null;
    }

    @Override
    public JobType getJobTypeById(int id) {
        return null;
    }

    @Override
    public List<JobType> getJobTypesByJob(int jobId) {
        return null;
    }

    @Override
    public JobType editJobType(JobType jobType) {
        return null;
    }

    @Override
    public boolean deleteJobType(int id) {
        return false;
    }

    @Override
    public void deleteJobTypesByJob(int jobId) {

    }
}
