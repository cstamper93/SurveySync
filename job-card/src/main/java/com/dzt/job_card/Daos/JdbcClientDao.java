package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Client;
import com.dzt.job_card.Models.JobCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
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

        return getClientById(newClientId);
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        String sql = "SELECT * FROM client WHERE client_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if(result.next()) {
            client = mapRowToClient(result);
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client ORDER BY last_name;";
        SqlRowSet results = template.queryForRowSet(sql);
        while(results.next()) {
            clients.add(mapRowToClient(results));
        }
        return clients;
    }

    @Override
    public Client editClient(Client updatedClient) {
        String sql = "UPDATE client SET first_name = ?, last_name = ?, company = ?, cell_phone_number = ?, " +
                "home_phone_number = ?, work_phone_number = ?, billing_address = ?, billing_town = ?, " +
                "billing_state = ?, billing_zip = ?, client_email = ?, alt_email = ?, client_notes = ? " +
                "WHERE client_id = ?;";
        template.update(sql, updatedClient.getFirstName(), updatedClient.getLastName(), updatedClient.getCompany(),
                updatedClient.getCellPhoneNumber(), updatedClient.getHomePhoneNumber(), updatedClient.getWorkPhoneNumber(),
                updatedClient.getBillingAddress(), updatedClient.getBillingTown(), updatedClient.getBillingState(),
                updatedClient.getBillingZip(), updatedClient.getClientEmail(), updatedClient.getAltEmail(),
                updatedClient.getClientNotes(), updatedClient.getClientId());

        return getClientById(updatedClient.getClientId());
    }

    @Override
    public boolean deleteClient(int clientId) {
        boolean success = false;
        String sql = "DELETE FROM client WHERE client_id = ?;";
        int clientUpdated = template.update(sql, clientId);
        if(clientUpdated == 1) {
            success = true;
        }
        return success;
    }

    // implement mapping method
    private Client mapRowToClient(SqlRowSet rowSet) {
        Client client = new Client();
        client.setClientId(rowSet.getInt("client_id"));
        client.setFirstName(rowSet.getString("first_name"));
        client.setLastName(rowSet.getString("last_name"));
        client.setCompany(rowSet.getString("company"));
        client.setCellPhoneNumber(rowSet.getString("cell_phone_number"));
        client.setHomePhoneNumber(rowSet.getString("home_phone_number"));
        client.setWorkPhoneNumber(rowSet.getString("work_phone_number"));
        client.setBillingAddress(rowSet.getString("billing_address"));
        client.setBillingTown(rowSet.getString("billing_town"));
        client.setBillingState(rowSet.getString("billing_state"));
        client.setBillingZip(rowSet.getString("billing_zip"));
        client.setClientEmail(rowSet.getString("client_email"));
        client.setAltEmail(rowSet.getString("alt_email"));
        client.setClientNotes(rowSet.getString("client_notes"));
        return client;
    }
}
