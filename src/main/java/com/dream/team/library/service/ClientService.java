package com.dream.team.library.service;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import com.dream.team.library.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    public List<Client> findAllByRole(Role role) {
        return clientRepository.findAllByRole(role);
    }
}
