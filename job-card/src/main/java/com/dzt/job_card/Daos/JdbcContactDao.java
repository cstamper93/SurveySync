package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Component
public class JdbcContactDao implements ContactDao {

    private final JdbcTemplate template;

    public JdbcContactDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public Contact addContact(Contact contact) {
        Contact newContact = new Contact();
        String sql = "INSERT INTO contact (date, time, user_id, job_id, client_id, method, description) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?);";
        template.update(sql, contact.getDate(), contact.getTime(), contact.getUserId(), contact.getJobId(),
                contact.getClientId(), contact.getMethod(), contact.getDescription());
        return null;
    }

    // 7/16 - add mapping method

    @Override
    public Contact getContactByDateTime(Date date, Time time) {
        String sql = "SELECT * FROM contact WHERE date = ? AND time = ?;";

        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return null;
    }

    @Override
    public List<Contact> getContactsByJob(int jobId) {
        return null;
    }

    @Override
    public List<Contact> getContactsByClient(int clientId) {
        return null;
    }

    @Override
    public List<Contact> getContactsByUser(int userId) {
        return null;
    }

    @Override
    public List<Contact> getContactsByDate(Date date) {
        return null;
    }

    @Override
    public Contact editContact(Contact contact) {
        return null;
    }

    @Override
    public boolean deleteContact(Date date, Time time) {
        return false;
    }

    @Override
    public int deleteContactsByJob(int jobId) {
        return 0;
    }
}
