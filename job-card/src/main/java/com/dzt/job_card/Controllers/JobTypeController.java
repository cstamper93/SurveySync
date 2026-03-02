package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.JobTypeDao;
import com.dzt.job_card.Models.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobTypeController {

    @Autowired
    JobTypeDao jobTypeDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-job-type")
    public JobType addJobType(@RequestBody JobType jobType) {
        return jobTypeDao.addJobType(jobType);
    }

    @GetMapping("/job-type/{id}")
    public JobType getJobTypeById(@PathVariable int id) {
        return jobTypeDao.getJobTypeById(id);
    }

    @GetMapping("/job-types/{id}")
    public List<String> getJobTypesByJob(@PathVariable int id) {
        System.out.println("controller " + id);
        List<String> jobTypeList = jobTypeDao.getJobTypesByJob(id);
        for(int i=0; i<jobTypeList.size(); i++) {
            System.out.println(jobTypeList.get(i));
        }
        //System.out.println(jobTypes);
        return jobTypeList;
    }

    @PutMapping("/job-type")
    public JobType editJobType(@RequestBody JobType jobType) {
        return jobTypeDao.editJobType(jobType);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/job-type/{id}")
    public boolean deleteJobType(@PathVariable int id) {
        return jobTypeDao.deleteJobType(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/job-type-job/{id}")
    public void deleteJobTypesByJob(@PathVariable int id) {
        jobTypeDao.deleteJobTypesByJob(id);
    }

}