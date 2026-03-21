package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobCard;

import java.util.Date;
import java.util.List;

public interface JobCardDao {

    // CRUD: create, read, update, delete

    JobCard createNewJobCard(JobCard jobCard);

    boolean addClientToJoinTable(int jobId, int clientId);

    boolean addPropertyToJoinTable(int jobId, int propId);

    JobCard getCardById(int id);

    List<JobCard> getAllJobCards();

    List<JobCard> filterProspectsByNumber(Integer jobNum);

    List<JobCard> filterActiveJobsByNumber(Integer activeJobNum);

    JobCard editJobCard(JobCard updatedCard);

    boolean deleteJobCard(int id);

    List<JobCard> filterByStatus(String status);

    List<JobCard> filterByContractSent(Date contractSentDate);

    List<JobCard> filterByContractSignedNoLetters();

    List<JobCard> filterByLettersSentNotPlotted();

    List<JobCard> filterByIsPlotted();

    List<JobCard> getJobsByClient(int clientId);

    // take in job details, return if any objects exist
    int getMatchingJobId(int clientId, int propertyId);

}
