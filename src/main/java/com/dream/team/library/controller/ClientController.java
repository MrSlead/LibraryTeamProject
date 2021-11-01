package com.dream.team.library.controller;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import com.dream.team.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Client> getClientById(@PathVariable Long idClient) {
        return clientService.findById(idClient);
    }

    @GetMapping("login/{login}")
    public Optional<Client> getClientByLogin(@PathVariable String login) {
        return clientService.findByLogin(login);
    }

    @GetMapping("all")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("premium")
    public List<Client> getPremiumClients() {
        return clientService.findAllByRole(Role.PREMIUM);
    }

    @GetMapping("ordinary")
    public List<Client> getOrdinaryClients() {
        return clientService.findAllByRole(Role.ORDINARY);
    }

    @PostMapping("add")
    public Optional<Client> addClient(@RequestBody Client client) {
        if(client == null) {
            return Optional.of(new Client());
        }

        client.setRole(Role.ORDINARY);

        return clientService.save(client);
    }
}
