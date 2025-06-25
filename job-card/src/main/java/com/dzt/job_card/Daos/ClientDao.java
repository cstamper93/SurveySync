package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Client;

import java.util.List;

public interface ClientDao {

    Client createNewClient(Client client);

    Client getClientById(int id);

    List<Client> getAllClients();

    Client editClient(Client updatedClient);

    boolean deleteClient(int clientId);


}
