package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.ClientPhoneDao;
import com.dzt.job_card.Models.ClientPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class ClientPhoneController {

    @Autowired
    ClientPhoneDao dao;

    @ResponseStatus(HttpStatus.CREATED)
    // @ssfsfsdsdf  ccvvcxv > Kelly's Code :)
    @PostMapping("/add-phone")
    public ClientPhone addClientPhone(@RequestBody ClientPhone phone) {
        ClientPhone newPhone = dao.createClientPhone(phone);
        if (newPhone == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to create new phone number for client.");
        } else {
            return newPhone;
        }
    }

    @GetMapping("/phone/{id}")
    public ClientPhone getPhoneById (@PathVariable int id) {
        return dao.getPhoneById(id);
    }

    @GetMapping("/phones/{id}")
    public List<ClientPhone> getAllPhonesForClient(@PathVariable int id) {
        return dao.getAllPhonesForClient(id);
    }

    @PutMapping("/edit-phone")
    public ClientPhone editClientPhone(@RequestBody ClientPhone phone) {
        ClientPhone updatedPhone = dao.editClientPhone(phone);
        if(updatedPhone == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone number not found.");
        } else {

        } return updatedPhone;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/phone/{id}")
    public boolean deletePhone(@PathVariable int id) {
        return dao.deleteClientPhone(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/phones/{id}")
    public void deleteAllClientPhones(@PathVariable int id) {
        dao.deleteAllClientPhones(id);
    }

}
