package com.dream.team.library.service;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();

    List<Client> findAllByRole(Role role);

    Optional<Client> findById(Long id);

    Optional<Client> findByEmail(String email);

    Optional<Client> findByLogin(String login);

    Optional<Client> save(Client client);

    void delete(Client client);

    void deleteById(Long id);

}
