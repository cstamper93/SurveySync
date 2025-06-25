package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcClientDao implements ClientDao {

    private final JdbcTemplate template;

    public JdbcClientDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public Client createNewClient(Client client) {
        String sql = "INSERT INTO client (first_name, last_name, company, cell_phone_number, home_phone_number, " +
                "work_phone_number, billing_address, billing_town, billing_state, billing_zip, client_email, " +
                "alt_email, client_notes) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        Integer newClientId = template.queryForObject(sql, Integer.class, client.getFirstName(), client.getLastName(),
                client.getCompany(), client.getCellPhoneNumber(), client.getHomePhoneNumber(),
                client.getWorkPhoneNumber(), client.getBillingAddress(), client.getBillingTown(),
                client.getBillingState(), client.getBillingZip(), client.getClientEmail(), client.getAltEmail(),
                client.getClientNotes());

        // wait to implement get by id class
        return null;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client editClient(Client updatedClient) {
        return null;
    }

    @Override
    public boolean deleteClient(int clientId) {
        return false;
    }

    // implement mapping method
    private Client mapRowToClient(SqlRowSet rowSet) {
        Client client = new Client();
        return null;
    }
}
