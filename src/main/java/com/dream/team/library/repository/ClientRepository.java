package com.dream.team.library.repository;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.converter.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends EntityRepository<Client> {
    Optional<Client> findByEmail(String email);
    Optional<Client> findByLogin(String login);
    List<Client> findAllByRole(Role role);
}
