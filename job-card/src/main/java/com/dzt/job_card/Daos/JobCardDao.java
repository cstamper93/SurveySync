package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobCard;

import java.util.List;

public interface JobCardDao {

    // CRUD: create, read, update, delete

    JobCard createNewJobCard(JobCard jobCard, int clientId, int propertyId);

    JobCard getCardById(int id);

    List<JobCard> getAllJobCards();

    // add ways to filter job card searches (ex: getCardsBy...clientName, city, associated crew members, etc...)

    List<JobCard> filterByNumber(Integer jobNum);

    List<JobCard> filterByName(String name);

    List<JobCard> filterByType(String type); // change type to FS, EPS, Division, Recombination, Construction, Other

    JobCard editJobCard(JobCard updatedCard);

    boolean deleteJobCard(int id);

}
