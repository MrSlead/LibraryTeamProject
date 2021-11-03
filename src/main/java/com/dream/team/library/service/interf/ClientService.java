package com.dream.team.library.service.interf;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.Role;
import java.util.List;
import java.util.Optional;

public interface ClientService extends AbstractService<Client, Long> {
    List<Client> findAllByRole(Role role);
    Optional<Client> findByEmail(String email);
    Optional<Client> findByLogin(String login);
    Optional<Client> findByLoginForJWT(String login);
}
