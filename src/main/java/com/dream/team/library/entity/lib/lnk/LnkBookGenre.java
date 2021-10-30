package com.dream.team.library.entity.lib.lnk;

import com.dream.team.library.entity.lib.Book;
import com.dream.team.library.entity.lib.Genre;
import com.dream.team.library.entity.lib.lnk.composite_key.LnkBookGenreKey;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LnkBookGenre implements AbstractLnk {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LnkBookGenreKey key;

    @ManyToOne
    @MapsId("bookId")
    @JsonManagedReference
    private Book book;

    @ManyToOne
    @MapsId("genreId")
    @JsonManagedReference
    private Genre genre;
}
