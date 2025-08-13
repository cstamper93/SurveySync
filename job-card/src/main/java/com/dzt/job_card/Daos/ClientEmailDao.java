package com.dzt.job_card.Daos;

import java.util.List;

public interface ClientEmailDao {

    ClientEmailDao createClientEmail(ClientEmailDao email);

    ClientEmailDao getEmailById(int emailId);

    List<ClientEmailDao> getAllEmailsForClient(int clientId);

    ClientEmailDao editClientEmail(ClientEmailDao email);

    boolean deleteEmail(int emailId);

    void deleteAllClientEmails(int clientId);

}
