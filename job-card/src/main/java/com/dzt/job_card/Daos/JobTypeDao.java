package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobType;

import java.util.List;

public interface JobTypeDao {

    JobType addJobType(JobType jobType);

    JobType getJobTypeById(int id);

    List<JobType> getJobTypesByJob(int jobId);

    JobType editJobType(JobType jobType);

    boolean deleteJobType(int id);

    void deleteJobTypesByJob(int jobId);
}
