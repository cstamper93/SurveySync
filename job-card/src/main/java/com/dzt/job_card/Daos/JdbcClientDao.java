package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Client;
import com.dzt.job_card.Models.JobCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClientDao implements ClientDao {

    private final JdbcTemplate template;

    public JdbcClientDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public Client createNewClient(Client client) {
        String sql = "INSERT INTO client (first_name, last_name, cell_phone, home_phone, work_phone, email, alt_email," +
                " company, billing_address, billing_town, " +
                "billing_state, billing_zip, client_notes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING client_id;";
        Integer newClientId = template.queryForObject(sql, Integer.class, client.getFirstName(), client.getLastName(),
                client.getCellPhone(), client.getHomePhone(), client.getHomePhone(), client.getWorkPhone(),
                client.getEmail(), client.getAltEmail(), client.getCompany(), client.getBillingAddress(),
                client.getBillingTown(), client.getBillingState(), client.getBillingZip(), client.getClientNotes());

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
        String sql = "UPDATE client SET first_name = ?, last_name = ?, cell_phone = ?, home_phone = ?, work_phone = ?, " +
                "email = ?, alt_email = ?, company = ?, billing_address = ?, " +
                "billing_town = ?, billing_state = ?, billing_zip = ?, client_notes = ? " +
                "WHERE client_id = ?;";
        template.update(sql, updatedClient.getFirstName(), updatedClient.getLastName(), updatedClient.getCellPhone(),
                updatedClient.getHomePhone(), updatedClient.getWorkPhone(), updatedClient.getEmail(),
                updatedClient.getAltEmail(), updatedClient.getCompany(), updatedClient.getBillingAddress(),
                updatedClient.getBillingTown(), updatedClient.getBillingState(), updatedClient.getBillingZip(),
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
        client.setCellPhone(rowSet.getString("cell_phone"));
        client.setCellPhone(rowSet.getString("cell_phone"));
        client.setHomePhone(rowSet.getString("home_phone"));
        client.setWorkPhone(rowSet.getString("work_phone"));
        client.setEmail(rowSet.getString("email"));
        client.setAltEmail(rowSet.getString("alt_email"));
        client.setCompany(rowSet.getString("company"));
        client.setBillingAddress(rowSet.getString("billing_address"));
        client.setBillingTown(rowSet.getString("billing_town"));
        client.setBillingState(rowSet.getString("billing_state"));
        client.setBillingZip(rowSet.getString("billing_zip"));
        client.setClientNotes(rowSet.getString("client_notes"));
        return client;
    }
}
