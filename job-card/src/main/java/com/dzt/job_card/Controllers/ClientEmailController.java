package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.ClientEmailDao;
import com.dzt.job_card.Models.Client;
import com.dzt.job_card.Models.ClientEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClientEmailController {

    @Autowired
    private ClientEmailDao dao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/email")
    public ClientEmail postClientEmail(@RequestBody ClientEmail email) {
        return dao.createClientEmail(email);
    }

    @GetMapping("/email/{id}")
    public ClientEmail getEmailById(@PathVariable int id) {
        return dao.getEmailById(id);
    }

    @GetMapping("/emails/{id}")
    public List<ClientEmail> getAllClientEmails(@PathVariable int id) {
        return dao.getAllEmailsForClient(id);
    }

    @PutMapping("/edit-email")
    public ClientEmail editEmail(@RequestBody ClientEmail email) {
        return dao.editClientEmail(email);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/email/{id}")
    public boolean deleteEmail(@PathVariable int id) {
        return dao.deleteEmail(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/emails/{id}")
    public void deleteAllClientEmails(@PathVariable int id) {
        dao.deleteAllClientEmails(id);
    }

}
