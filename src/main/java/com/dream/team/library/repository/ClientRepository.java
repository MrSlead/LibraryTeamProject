package com.dream.team.library.repository;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends EntityRepository<Client> {
    Client findByLogin(String login);
    List<Client> findAllByRole(Role role);
}
