package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.ContactDao;
import com.dzt.job_card.Models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ContactController {

    @Autowired
    ContactDao contactDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/contact")
    public Contact storeContact(@RequestBody Contact contact) {
        return contactDao.addContact(contact);
    }

    @GetMapping("/contact-id/{id}")
    public Contact fetchContactById(@PathVariable int id) {
        return contactDao.getContactById(id);
    }

    @GetMapping("/contact-all")
    public List<Contact> fetchAllContacts() {
        return contactDao.getAllContacts();
    }

    @GetMapping("/contact-job/{id}")
    public List<Contact> fetchContactsByJob(@PathVariable int id) {
        return contactDao.getContactsByJob(id);
    }

    @GetMapping("/contact-client/{id}")
    public List<Contact> fetchContactsByClient(@PathVariable int id) {
        return contactDao.getContactsByClient(id);
    }

    @GetMapping("/contact-user/{id}")
    public List<Contact> fetchContactsByUser(@PathVariable int id) {
        return contactDao.getContactsByUser(id);
    }

    @GetMapping("/contact-date")
    public List<Contact> fetchContactsByDate(@RequestBody Date date) {
        return contactDao.getContactsByDate(date);
    }

    @PutMapping("/contact")
    public Contact updateContact(@RequestBody Contact contact) {
        return contactDao.editContact(contact);
    }

}
