package com.dream.team.library.service.impl;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import com.dream.team.library.repository.ClientRepository;
import com.dream.team.library.service.interf.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Optional<Client> findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public List<Client> findAllByRole(Role role) {
        return clientRepository.findAllByRole(role);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    @Override
    public Optional<Client> save(Client client) {
        return Optional.of(clientRepository.save(client));
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
