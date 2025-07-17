package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.Contact;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ContactDao {

    Contact addContact(Contact contact);

    Contact getContactByDateTime(Date date, Time time);

    List<Contact> getAllContacts();

    List<Contact> getContactsByJob(int jobId);

    List<Contact> getContactsByClient(int clientId);

    List<Contact> getContactsByUser(int userId);

    List<Contact> getContactsByDate(Date date);

    Contact editContact(Contact contact);

    boolean deleteContact(Date date, Time time);

    int deleteContactsByJob(int jobId);

}
