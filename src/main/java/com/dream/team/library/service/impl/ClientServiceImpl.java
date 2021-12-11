package com.dream.team.library.service.impl;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import com.dream.team.library.repository.ClientRepository;
import com.dream.team.library.service.interf.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {
            log.info("Returned the Client by id: " + id);
            log.debug("Client: " + client.get());
        }
        else {
            log.info("Couldn't find the Client by id: " + id);
        }

        return client;
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        Optional<Client> client = clientRepository.findByEmail(email);

        if(client.isPresent()) {
            log.info("Returned the Client by email: " + email);
            log.debug("Client: " + client.get());
        }
        else {
            log.info("Couldn't find the Client by id: " + email);
        }

        return client;
    }

    @Override
    public Optional<Client> findByLogin(String login) {
        Optional<Client> client = clientRepository.findByLogin(login);

        if(client.isPresent()) {
            log.info("Returned the Client by login: " + login);
            log.debug("Client: " + client.get());
        }
        else {
            log.info("Couldn't find the Client by id: " + login);
        }

        return client;
    }

    @Override
    public Optional<Client> findByLoginForJWT(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public List<Client> findAllByRole(Role role) {
        List<Client> clientList = clientRepository.findAllByRole(role);

        log.info("Returned the Clients by role: " + role.name());
        log.debug("Size of clients: " + clientList.size());

        return clientList;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clientList = clientRepository.findAll();

        log.info("Returned all Clients");
        log.debug("Size of clients: " + clientList.size());

        return clientList;
    }
    @Override
    public Client save(Client client) {
        log.info("Saved the client");
        log.debug("Client: " + client);

        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> update(Client client) {
        log.info("Updated the client");
        log.debug("Client: " + client);

        if (client == null || client.getId() == null || clientRepository.findById(client.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(clientRepository.save(client));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {
            log.info("Deleted the Client by id: " + id);
            log.debug("Client: " + client.get());
        }
        else {
            log.info("Couldn't find the Client by id: " + id);
        }

        clientRepository.deleteById(id);
    }

    @Override
    public void delete(Client client) {
        log.info("Deleted the client");
        log.debug("Client: " + client);

        clientRepository.delete(client);
    }
}
