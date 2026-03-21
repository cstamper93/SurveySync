package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.JobCardDao;
import com.dzt.job_card.Models.JobCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class JobCardController {

    @Autowired
    JobCardDao jobCardDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-card")
    public JobCard addJobCard(@RequestBody JobCard card) {
        JobCard newCard = jobCardDao.createNewJobCard(card);
        if(newCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to create new card");
        } else {
            return newCard;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add-job-client/{jobId}/{clientId}")
    public boolean addClientToJoinTable(@PathVariable int jobId, @PathVariable int clientId) {
        return jobCardDao.addClientToJoinTable(jobId, clientId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add-job-prop/{jobId}/{propId}")
    public boolean addPropertyToJoinTable(@PathVariable int jobId, @PathVariable int propId) {
        return jobCardDao.addPropertyToJoinTable(jobId, propId);
    }

    @GetMapping("/job-card/{id}")
    public JobCard getCardById(@PathVariable int id) {
        return jobCardDao.getCardById(id);
    }

    @GetMapping("/job-cards")
    public List<JobCard> getAllJobCards() {
        return jobCardDao.getAllJobCards();
    }

    @GetMapping("/job-cards-by-num/{prospectNum}")
    public List<JobCard> filterCardsByNumber(@PathVariable Integer prospectNum) {
        return jobCardDao.filterProspectsByNumber(prospectNum);
    }

    // Should I pass in another way to hide client names??
    @GetMapping("/active-cards-by-num/{num}")
    public List<JobCard> filterActiveJobsByNumber(@PathVariable Integer num) {
        return jobCardDao.filterActiveJobsByNumber(num);
    }

    @PutMapping("/job-cards") // you can put methods in same endpoint w/diff http requests
    public JobCard editCard(@RequestBody JobCard card) {
        JobCard updatedCard = jobCardDao.editJobCard(card);
        if(updatedCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "card not found");
        } else {
            return updatedCard;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/job-cards/{id}") // throw exception here??
    public boolean deleteCard(@PathVariable int id) {
        return jobCardDao.deleteJobCard(id);
    }

    @GetMapping("/jobs-by-status/{status}")
    public List<JobCard> filterByStatus(@PathVariable String status) {
        return jobCardDao.filterByStatus(status);
    }

    @GetMapping("/contract-sent/{date}")
    public List<JobCard> filterByContractSent(@PathVariable Date date) {
        return jobCardDao.filterByContractSent(date);
    }

    @GetMapping("/contract-signed")
    public List<JobCard> filterByContractSignedNoLetters() {
        return jobCardDao.filterByContractSignedNoLetters();
    }

    @GetMapping("/letters-sent")
    public List<JobCard> filterByLettersSentNotPlotted() {
        return jobCardDao.filterByLettersSentNotPlotted();
    }

    @GetMapping("/plotted")
    public List<JobCard> filterByIsPlotted() {
        return jobCardDao.filterByIsPlotted();
    }

    @GetMapping("/clients-jobs/{clientId}")
    public List<JobCard> getJobsByClient(int clientId) {
        return jobCardDao.getJobsByClient(clientId);
    }

    @GetMapping("/job-match/{clientId}/{propertyId}")
    public int getMatchingJobId(@PathVariable int clientId, @PathVariable int propertyId) {
        return jobCardDao.getMatchingJobId(clientId, propertyId);
    }
}