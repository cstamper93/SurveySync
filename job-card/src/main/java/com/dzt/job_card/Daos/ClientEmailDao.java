package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ClientEmail;

import java.util.List;

public interface ClientEmailDao {

    ClientEmail createClientEmail(ClientEmail email);

    ClientEmail getEmailById(int emailId);

    List<ClientEmail> getAllEmailsForClient(int clientId);

    ClientEmail editClientEmail(ClientEmail email);

    boolean deleteEmail(int emailId);

    void deleteAllClientEmails(int clientId);

}
