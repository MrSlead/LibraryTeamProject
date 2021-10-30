package com.dream.team.library.entity.lib;

import com.dream.team.library.entity.AbstractEntity;
import com.dream.team.library.entity.lib.lnk.LnkBookAuthor;
import com.dream.team.library.entity.lib.lnk.LnkBookGenre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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

    private Date dateOfPublication;

    @ManyToOne
    @JsonManagedReference
    private Language language;

    private int numberOfPages;

    @OneToMany(mappedBy = "book")
    @JsonBackReference
    private Set<LnkBookGenre> lnkBookGenres;

    @OneToMany(mappedBy = "book")
    @JsonBackReference
    private Set<LnkBookAuthor> lnkBookAuthors;
}
