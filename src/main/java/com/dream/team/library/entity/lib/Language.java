package com.dream.team.library.entity.lib;

import com.dream.team.library.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Language implements AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_generator")
    @SequenceGenerator(name = "language_generator", sequenceName = "language_seq", allocationSize = 1)
    private Long id;

    private String name;
}
