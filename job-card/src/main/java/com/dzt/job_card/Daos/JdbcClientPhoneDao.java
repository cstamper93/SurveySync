package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientPhone;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcClientPhoneDao implements ClientPhoneDao{

    private final JdbcTemplate template;

    public JdbcClientPhoneDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public ClientPhone createClientPhone(ClientPhone clientPhone) {
        return null;
    }

    @Override
    public List<ClientPhone> getAllPhonesForClient(int clientId) {
        return null;
    }

    @Override
    public ClientPhone editClientPhone(ClientPhone clientPhone) {
        return null;
    }

    @Override
    public boolean deleteClientPhone(int clientId, int phoneId) {
        return false;
    }

    @Override
    public void deleteAllClientPhones(int clientId) {

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
