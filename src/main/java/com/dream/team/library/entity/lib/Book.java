package com.dream.team.library.entity.lib;

import com.dream.team.library.entity.AbstractEntity;
import com.dream.team.library.entity.lib.lnk.LnkBookAuthor;
import com.dream.team.library.entity.lib.lnk.LnkBookGenre;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfPublication;

    @ManyToOne
    private Language language;

    private int numberOfPages;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private final Set<LnkBookGenre> lnkBookGenres = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private final Set<LnkBookAuthor> lnkBookAuthors = new HashSet<>();
}
