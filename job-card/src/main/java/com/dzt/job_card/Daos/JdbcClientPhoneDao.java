package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientPhone;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClientPhoneDao implements ClientPhoneDao{

    private final JdbcTemplate template;

    public JdbcClientPhoneDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public ClientPhone createClientPhone(ClientPhone clientPhone) {
        String sql = "INSERT INTO client_phone (client_id, phone_number, phone_type) " +
                "VALUES(?, ?, ?) RETURNING phone_id;";
        Integer newId = template.queryForObject(sql, Integer.class, clientPhone.getClientId(),
                clientPhone.getPhoneNumber(), clientPhone.getPhoneType());
        return getPhoneById(newId);
    }

    @Override
    public ClientPhone getPhoneById(int phoneId) {
        ClientPhone clientPhone = new ClientPhone();
        String sql = "SELECT * FROM client_phone WHERE phone_id = ?;";
        SqlRowSet result = template.queryForRowSet(sql, phoneId);
        if (result.next()) {
            clientPhone = mapRowToClientPhone(result);
        } else {
            System.out.println("No phone number found at this id.");
        }
        return clientPhone;
    }

    @Override
    public List<ClientPhone> getAllPhonesForClient(int clientId) {
        List<ClientPhone> clientPhoneNumbers = new ArrayList<>();
        String sql = "SELECT * FROM client_phone WHERE client_id = ?;";
        SqlRowSet results = template.queryForRowSet(sql, clientId);
        while (results.next()) {
            clientPhoneNumbers.add(mapRowToClientPhone(results));
        }
        return clientPhoneNumbers;
    }

    @Override
    public ClientPhone editClientPhone(ClientPhone clientPhone) {
        ClientPhone editedPhone = new ClientPhone();
        String sql = "UPDATE client_phone SET phone_id = ?, client_id = ?, phone_number = ?, phone_type = ? " +
                "WHERE phone_id = ?;";
        template.update(sql, clientPhone.getPhoneId(), clientPhone.getClientId(), clientPhone.getPhoneNumber(),
                clientPhone.getPhoneType(), clientPhone.getPhoneId());
        return getPhoneById(clientPhone.getPhoneId());
    }

    @Override
    public boolean deleteClientPhone(int clientId, int phoneId) {
        boolean success = false;
        String sql = "DELETE FROM client_phone WHERE  phone_id = ?";
        int rowsUpdated = template.update(sql, phoneId);
        if (rowsUpdated == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public void deleteAllClientPhones(int clientId) {
        String sql = "DELETE FROM client_phone WHERE client_id = ?;";
        template.update(sql, clientId);
    }

    private ClientPhone mapRowToClientPhone(SqlRowSet rowSet) {
        ClientPhone clientPhone = new ClientPhone();
        clientPhone.setPhoneId(rowSet.getInt("phone_id"));
        clientPhone.setClientId(rowSet.getInt("client_id"));
        clientPhone.setPhoneNumber(rowSet.getString("phone_number"));
        clientPhone.setPhoneType(rowSet.getString("phone_type"));
        return clientPhone;
    }
}
