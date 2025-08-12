package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientPhone;

import java.util.List;

public interface ClientPhoneDao {

    ClientPhone createClientPhone(ClientPhone clientPhone);

    ClientPhone getPhoneById(int phoneId);

    List<ClientPhone> getAllPhonesForClient(int clientId);

    ClientPhone editClientPhone(ClientPhone clientPhone);

    boolean deleteClientPhone(int clientId, int phoneId);

    void deleteAllClientPhones(int clientId);
}
