package com.dream.team.library.entity.authorization;

import com.dream.team.library.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String surname;
    private String patronymic;
    @JsonIgnore
    private String login;
    private String email;
    @JsonIgnore
    private String password;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Role role;
}
