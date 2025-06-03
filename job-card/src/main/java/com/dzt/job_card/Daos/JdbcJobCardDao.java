package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.JobCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcJobCardDao implements JobCardDao {

    private final JdbcTemplate template; // used to communicate with db

    public JdbcJobCardDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public JobCard createNewJobCard(JobCard jobCard, int clientId, int propertyId) {
        // 5/29 - usually, a new job comes with a new client and property. So, why not make inserts for them as well?
        // ACTUALLY, we can use the controller to call the client and other jdbc methods. Just contain it to
        // job card for now
        String jobCardSql = "INSERT INTO job_card (prospect_id, active_job_id, intake_date, intake_time, " +
                "marked_lines_length, job_description, house_plan_name, job_status, ready_date, complete_by_date, " +
                "contract_sent_date, contract_signed, contract_signed_date, letters_sent, letters_sent_date, is_plotted, " +
                "plotted_by) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING id;";
        // include an insert for the lookup table(s)?
        // Probably, since jobCard is the "central" object - makes more sense to do that here
        Integer newJobId = template.queryForObject(jobCardSql, Integer.class, jobCard.getProspectId(),
                jobCard.getActiveJobId(), jobCard.getIntakeDate(), jobCard.getIntakeTime(),
                jobCard.getMarkLinesLength(), jobCard.getJobDescription(), jobCard.getHousePlanName(),
                jobCard.getJobStatus(), jobCard.getReadyDate(), jobCard.getCompleteByDate(), jobCard.getContractSentDate(),
                jobCard.isContractSigned(), jobCard.getContractSignedDate(), jobCard.isLettersSent(), jobCard.getLettersSentDate(),
                jobCard.isPlotted(), jobCard.getPlottedBy());

        String jobCardClientSql = "INSERT INTO job_card_client (job_id, client_id) VALUES(?, ?);";
        template.update(jobCardClientSql, jobCard.getJobId(), clientId);
        // Do I need to us query for object instead? We shall see

        String jobCardPropertySql = "INSERT INTO job_card_property (job_id, prop_id) VALUES (?, ?);";
        template.update(jobCardPropertySql, jobCard.getJobId(), propertyId);

        return getCardById(newJobId); // Null pointer?? How do I handle this particular one??
    }

    @Override
    // 5/29 - fix to wrap in client, property, and jobtype (jobnotes too??)
    // 6/3 - yes and contact - REVIEW JOINS
    public JobCard getCardById(int id) {
        JobCard jobCard = null;
        String jobCardSql = "SELECT * FROM job_card WHERE id = ?;";

        SqlRowSet results = template.queryForRowSet(jobCardSql, id);
        if(results.next()) {
            jobCard = mapRowToJobCard(results);
        }
        return jobCard;
    }

    @Override
    // 5/29 - probably need to update to wrap in property, client, and job type (and job notes??) using joins (yay!)
    // GIVE OPTIONS TO RETURN FROM NEWEST TO OLDEST, OLDEST TO NEWEST, ALPHABETICAL BY CLIENT NAME, ETC ETC!?
    public List<JobCard> getAllJobCards() {
        List<JobCard> jobCardList = new ArrayList<>();
        String sql = "SELECT * FROM job_card;";
        SqlRowSet results = template.queryForRowSet(sql);
        while(results.next()) {
            jobCardList.add(mapRowToJobCard(results));
        }
        return jobCardList;
    }

    @Override
    // edit to wrap in clients props types and notes
    public List<JobCard> filterByNumber(Integer jobNum) {
        List<JobCard> jobCardList = new ArrayList<>();
        String sql = "SELECT * FROM job_card WHERE job_number = ?;";
        SqlRowSet results = template.queryForRowSet(sql,  jobNum);
        while(results.next()) {
            jobCardList.add(mapRowToJobCard(results));
        }
        return jobCardList;
    }

    @Override
    // edit to include all the things :)
    public List<JobCard> filterByName(String name) {
        List<JobCard> filteredList = new ArrayList<>();
        String sql = "SELECT * FROM job_card WHERE LOWER(client_name) LIKE LOWER(?);";
        String preparedStatement = "%" + name.toLowerCase() + "%";
        SqlRowSet results = template.queryForRowSet(sql, preparedStatement);
        while(results.next()) {
            filteredList.add(mapRowToJobCard(results));
        }

        for(int i=0; i<filteredList.size(); i++) {
            System.out.println(filteredList.get(i).getClientName());
        }

        return filteredList;
    }

    @Override
    // edit to include all the things :)
    public List<JobCard> filterByType(String type) {
        List<JobCard> filteredCards = new ArrayList<>();
        String sql = "SELECT * FROM job_card WHERE job_type = ?;";
        SqlRowSet results = template.queryForRowSet(sql, type);
        while(results.next()) {
            filteredCards.add(mapRowToJobCard(results));
        }
        return filteredCards;
    }

    @Override
    // edit join tables too
    public JobCard editJobCard(JobCard updatedCard) {
        String sql = "UPDATE job_card SET job_number = ?, client_name = ?, phone_number = ?, alt_phone_number = ?, " +
                "client_email = ?, alt_email = ?, job_address = ?, job_type = ?, job_status = ?, complete_by = ? " +
                "WHERE id = ?;";
        template.update(sql, updatedCard.getJobNumber(), updatedCard.getClientName(), updatedCard.getPhoneNumber(),
                updatedCard.getAltPhoneNumber(), updatedCard.getClientEmail(), updatedCard.getAltEmail(),
                updatedCard.getJobAddress(), updatedCard.getJobType(), updatedCard.getJobStatus(),
                updatedCard.getCompleteBy(), updatedCard.getId());

        return getCardById(updatedCard.getId());
    }

    @Override
    // delete join rows too, and type and notes (but not properties or clients themselves!)
    public boolean deleteJobCard(int id) {
        boolean success = false;
        String sql = "DELETE FROM job_card WHERE id = ?;";
        int linesUpdated = template.update(sql, id);
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }

    // Mapping method to help other methods that return a JobCard object and have to read from db
    private JobCard mapRowToJobCard(SqlRowSet rowSet) {
        JobCard jobCard = new JobCard();
        jobCard.setJobId(rowSet.getInt("job_id"));
        jobCard.setProspectId(rowSet.getString("prospect_id"));
        jobCard.setActiveJobId(rowSet.getString("active_job_id"));
        jobCard.setIntakeDate(rowSet.getDate("intake_date"));
        jobCard.setIntakeTime(rowSet.getTime("intake_time"));
        jobCard.setMarkLinesLength(rowSet.getInt("marked_lines_length"));
        jobCard.setJobDescription(rowSet.getString("job_description"));
        jobCard.setHousePlanName(rowSet.getString("house_plan_name"));
        jobCard.setJobStatus(rowSet.getString("job_status"));
        jobCard.setReadyDate(rowSet.getDate("ready_date"));
        jobCard.setCompleteByDate(rowSet.getDate("complete_by_date"));
        jobCard.setContractSentDate(rowSet.getDate("contract_sent_date"));
        jobCard.setContractSigned(rowSet.getBoolean("contract_signed"));
        jobCard.setContractSignedDate(rowSet.getDate("contract_signed_date"));
        jobCard.setLettersSent(rowSet.getBoolean("letters_sent"));
        jobCard.setLettersSentDate(rowSet.getDate("letters_sent_date"));
        jobCard.setPlotted(rowSet.getBoolean("is_plotted"));
        jobCard.setPlottedBy(rowSet.getString("plotted_by"));
        return jobCard;
    }
}
