package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientEmail;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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
        return null;
    }

    @Override
    public ClientEmail editClientEmail(ClientEmail email) {
        return null;
    }

    @Override
    public boolean deleteEmail(int emailId) {
        return false;
    }

    @Override
    public void deleteAllClientEmails(int clientId) {

    }

    private ClientEmail mapRowToClientEmail(SqlRowSet rowSet) {
        ClientEmail email = new ClientEmail();
        email.setEmailId(rowSet.getInt("email_id"));
        email.setClientId(rowSet.getInt("client_id"));
        email.setEmailAddress(rowSet.getString("email_address"));
        return email;
    }
}
