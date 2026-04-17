package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.ClientDao;
import com.dzt.job_card.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    ClientDao clientDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-client")
    public Client addNewClient(@RequestBody Client client) {
        Client newClient = clientDao.createNewClient(client);
        if(newClient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to create new client. Bummer!");
        } else {
            return newClient;
        }
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientDao.getClientById(id);
    }

    @GetMapping("/client-name/{first}/{last}")
    public int getClientByName(@PathVariable String first, @PathVariable String last) {
        return clientDao.getClientByName(first, last);
    }

    @GetMapping("/client-name/{jobId}")
    public List<Client> getClientByJobId(@PathVariable int jobId) {
        return clientDao.getClientsByJobId(jobId);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @PutMapping("/client")
    public Client editClient(@RequestBody Client client) {
        Client updatedClient = clientDao.editClient(client);
        if(updatedClient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found - there is no client here " +
                    "to edit!");
        } else {
            return updatedClient;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/client/{id}")
    public boolean deleteClient(@PathVariable int id) {
        return clientDao.deleteClient(id);
    }

}
