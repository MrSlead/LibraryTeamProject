package com.dream.team.library.controller;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import com.dream.team.library.payload.ClientApiString;
import com.dream.team.library.service.interf.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
// Разрешение на получение данных только из указанного источника
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${client.api.begin}")
public class ClientController {
    private ClientService clientService;
    private ClientApiString clientApiString;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setClientApiString(ClientApiString clientApiString) {
        this.clientApiString = clientApiString;
    }

    @GetMapping("${client.api.getById}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long clientId) {
        log.info("API was called: " + clientApiString.getClientApiGetById());

        if(clientId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Client> client = clientService.findById(clientId);

        if(client.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("${client.api.getByLogin}")
    public ResponseEntity<Optional<Client>> getClientByLogin(@PathVariable String login) {
        log.info("API was called: " + clientApiString.getClientApiGetByLogin());

        if(login == null || login.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Client> client = clientService.findByLogin(login);

        if(client.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("${client.api.getAll}")
    public ResponseEntity<List<Client>> findAll() {
        log.info("API was called: " + clientApiString.getClientApiGetAll());
        List<Client> clientList = clientService.findAll();

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("${client.api.getPremium}")
    public ResponseEntity<List<Client>> getPremiumClients() {
        log.info("API was called: " + clientApiString.getClientApiGetPremium());
        List<Client> clientList = clientService.findAllByRole(Role.PREMIUM);

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("${client.api.getOrdinary}")
    public ResponseEntity<List<Client>> getOrdinaryClients() {
        log.info("API was called: " + clientApiString.getClientApiGetOrdinary());
        List<Client> clientList = clientService.findAllByRole(Role.ORDINARY);

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    /*@PostMapping("add")
    public ResponseEntity<Optional<Client>> addClient(@RequestBody Client client) {
        Optional<Client> clientOptional = Optional.of(client);
        if(clientOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientOptional.get().setRole(Role.ORDINARY);
        clientService.save(clientOptional.get());

        return new ResponseEntity<>(clientOptional, HttpStatus.CREATED);
    }*/
}
