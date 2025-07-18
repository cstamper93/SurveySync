package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.ArrayList;
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
                "VALUES(?, ?, ?, ?, ?, ?, ?) RETURNING contact_id;";
        Integer newId = template.update(sql, Integer.class, contact.getDate(), contact.getTime(), contact.getUserId(), contact.getJobId(),
                contact.getClientId(), contact.getMethod(), contact.getDescription());

        return getContactById(newId);
    }

    @Override
    public Contact getContactById(int id) {
        Contact contact = new Contact();
        String sql = "SELECT * FROM contact WHERE contact_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if (result.next()) {
            contact = mapRowToContact(result);
        }
        return contact;
    }


    // Should this ever be used?? This List could become quite large!
    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact ORDER BY date AND time;";
        SqlRowSet results = template.queryForRowSet(sql);
        while(results.next()) {
            contacts.add(mapRowToContact(results));
        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByJob(int jobId) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact WHERE job_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, jobId);
        while(results.next()) {
            contacts.add(mapRowToContact(results));
        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByClient(int clientId) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact WHERE client_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, clientId);
        while(results.next()) {
            contacts.add(mapRowToContact(results));
        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByUser(int userId) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact WHERE user_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, userId);
        while(results.next()) {
            contacts.add(mapRowToContact(results));
        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByDate(Date date) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact WHERE date = ? ORDER BY date DESC;";
        SqlRowSet results = template.queryForRowSet(sql, date);
        while(results.next()) {
            contacts.add(mapRowToContact(results));
        }
        return contacts;
    }

    @Override
    public Contact editContact(Contact contact) {
        String sql = "UPDATE contact SET date = ?, time = ?, user_id = ?, job_id = ?, client_id = ?, " +
                "method = ?, description = ? WHERE contact_id = ?;";
        template.update(sql, contact.getContactId(), contact.getDate(), contact.getTime(), contact.getUserId(),
                contact.getJobId(), contact.getClientId(), contact.getMethod(), contact.getDescription(),
                contact.getClientId());

        return getContactById(contact.getContactId());
    }

    @Override
    public boolean deleteContact(int id) {
        boolean success = false;
        String sql = "DELETE * FROM contact WHERE contact_id = ?;";
        int lineUpdated = template.update(sql, id);
        if(lineUpdated == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public int deleteContactsByJob(int jobId) {
        String sql = "DELETE * FROM contact WHERE job_id = ?;";
        int linesUpdated = template.update(sql, jobId);
        return linesUpdated;
    }

    private Contact mapRowToContact(SqlRowSet rs) {
        Contact contact = new Contact();
        contact.setContactId(rs.getInt("contact_id"));
        contact.setDate(rs.getDate("date"));
        contact.setTime(rs.getTime("time"));
        contact.setUserId(rs.getInt("user_id"));
        contact.setJobId(rs.getInt("job_id"));
        contact.setClientId(rs.getInt("client_id"));
        contact.setMethod(rs.getString("method"));
        contact.setDescription(rs.getString("description"));
        return contact;
    }

}
