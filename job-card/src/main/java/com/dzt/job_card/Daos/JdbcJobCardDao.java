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
    public JobCard createNewJobCard(JobCard jobCard) {
        String sql = "INSERT INTO job_card (prospect_id, active_job_id, intake_date, client_name, phone_number, " +
                "alt_phone_number, billing_address, billing_town, billing_state, billing_zip, client_email, alt_email," +
                "property_owner_first, property_owner_last," +
                " job_address, job_town, job_state, job_zip, deed_book, deed_page, map_book, map_page, parcel_perimeter, " +
                "new_lines_length, acreage, job_type, job_description, job_status, complete_by) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING id;";
        // include an insert for the lookup table?
        Integer newJobId = template.queryForObject(sql, Integer.class, jobCard.getJobNumber(), jobCard.getClientName(),
                jobCard.getPhoneNumber(), jobCard.getAltPhoneNumber(), jobCard.getClientEmail(),
                jobCard.getAltEmail(), jobCard.getJobAddress(), jobCard.getJobType(), jobCard.getJobStatus(),
                jobCard.getCompleteBy());

        return getCardById(newJobId); // Null pointer??
    }

    @Override
    public JobCard getCardById(int id) {
        JobCard jobCard = null;
        String sql = "SELECT * FROM job_card WHERE id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, id);
        if(results.next()) {
            jobCard = mapRowToJobCard(results);
        }
        return jobCard;
    }

    @Override
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
        jobCard.setContractSigned(rowSet.getBoolean("contract_signed"));
        jobCard.setContractSignedDate(rowSet.getDate("contract_signed_date"));
        jobCard.setLettersSent(rowSet.getBoolean("letters_sent"));
        jobCard.setLettersSentDate(rowSet.getDate("letters_sent_date"));
        jobCard.setPlotted(rowSet.getBoolean("is_plotted"));
        jobCard.setPlottedBy(rowSet.getString("plotted_by"));
        return jobCard;
    }
}
