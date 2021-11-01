package com.dream.team.library.controller;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import com.dream.team.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/client/")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("id/{idClient}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long idClient) {
        if(idClient == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<Client> client = clientService.findById(idClient);

        if(client.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("login/{login}")
    public ResponseEntity<Optional<Client>> getClientByLogin(@PathVariable String login) {
        if(login == null || login.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<Client> client = clientService.findByLogin(login);

        if(client.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientList = clientService.findAll();

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("premium")
    public ResponseEntity<List<Client>> getPremiumClients() {
        List<Client> clientList = clientService.findAllByRole(Role.PREMIUM);

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("ordinary")
    public ResponseEntity<List<Client>> getOrdinaryClients() {
        List<Client> clientList = clientService.findAllByRole(Role.ORDINARY);

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Optional<Client>> addClient(@RequestBody Client client) {
        Optional<Client> clientOptional = Optional.of(client);
        if(clientOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clientOptional.get().setRole(Role.ORDINARY);
        clientService.save(clientOptional.get());

        return new ResponseEntity<>(clientOptional, HttpStatus.OK);
    }
}
