package com.dream.team.library.entity.authorization;

import com.dream.team.library.entity.AbstractEntity;
import com.dream.team.library.entity.authorization.converter.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Client implements AbstractEntity {
    private static final long serialVersionUID = 1L;

    public Client(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @SequenceGenerator(name = "client_generator", sequenceName = "client_seq", allocationSize = 1)
    private Long id;
    private String login;
    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
