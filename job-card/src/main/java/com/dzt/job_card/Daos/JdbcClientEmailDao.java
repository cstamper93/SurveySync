package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientEmail;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClientEmailDao implements ClientEmailDao {

    private final JdbcTemplate template;

    public JdbcClientEmailDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public ClientEmail createClientEmail(ClientEmail email) {
        ClientEmail newEmail = new ClientEmail();
        String sql = "INSERT INTO client_email (client_id, email_address) VALUES(?, ?) " +
                "RETURNING email_id;";
        Integer newId = template.queryForObject(sql, Integer.class, email.getClientId(), email.getEmailAddress());
        return getEmailById(newId);
    }

    @Override
    public ClientEmail getEmailById(int emailId) {
        ClientEmail email = new ClientEmail();
        String sql = "SELECT * FROM client_email WHERE email_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, emailId);
        if (result.next()) {
            email = mapRowToClientEmail(result);
        } else {
            System.out.println("No email found at this id");
        }
        return email;
    }

    @Override
    public List<ClientEmail> getAllEmailsForClient(int clientId) {
        List<ClientEmail> emails = new ArrayList<>();
        String sql = "SELECT * FROM client_email WHERE client_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, clientId);
        while (results.next()) {
            emails.add(mapRowToClientEmail(results));
        }
        return emails;
    }

    @Override
    public ClientEmail editClientEmail(ClientEmail email) {
        ClientEmail updatedEmail = new ClientEmail();
        String sql = "UPDATE client_email SET email_id = ?, client_id = ?, email_address = ?;";
        template.update(sql, email.getEmailId(), email.getClientId(), email.getEmailAddress());
        return getEmailById(email.getEmailId());
    }

    @Override
    public boolean deleteEmail(int emailId) {
        boolean success = false;
        String sql = "DELETE FROM client_email WHERE email_id = ?;";
        int rowsUpdated = template.update(sql, emailId);
        if (rowsUpdated == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public void deleteAllClientEmails(int clientId) {
        String sql = "DELETE FROM client_email WHERE client_id = ?;";
        template.update(sql);
    }

    private ClientEmail mapRowToClientEmail(SqlRowSet rowSet) {
        ClientEmail email = new ClientEmail();
        email.setEmailId(rowSet.getInt("email_id"));
        email.setClientId(rowSet.getInt("client_id"));
        email.setEmailAddress(rowSet.getString("email_address"));
        return email;
    }
}
