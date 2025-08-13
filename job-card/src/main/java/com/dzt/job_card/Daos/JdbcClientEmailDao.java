package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientEmail;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public ClientEmailDao createClientEmail(ClientEmailDao email) {
        ClientEmail newEmail = new ClientEmail();
        String sql = "SELECT * FROM client_email";
    }

    @Override
    public ClientEmailDao getEmailById(int emailId) {
        return null;
    }

    @Override
    public List<ClientEmailDao> getAllEmailsForClient(int clientId) {
        return null;
    }

    @Override
    public ClientEmailDao editClientEmail(ClientEmailDao email) {
        return null;
    }

    @Override
    public boolean deleteEmail(int emailId) {
        return false;
    }

    @Override
    public void deleteAllClientEmails(int clientId) {

    }
}
