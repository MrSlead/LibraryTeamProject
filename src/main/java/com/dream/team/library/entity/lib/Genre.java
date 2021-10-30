package com.dream.team.library.entity.lib;

import com.dream.team.library.entity.AbstractEntity;
import com.dream.team.library.entity.lib.lnk.LnkBookGenre;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Genre implements AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_generator")
    @SequenceGenerator(name = "genre_generator", sequenceName = "genre_seq", allocationSize = 1)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "genre")
    @JsonBackReference
    private Set<LnkBookGenre> lnkBookGenres;
}
