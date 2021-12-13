package com.dream.team.library.entity.lib.lnk.composite_key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LnkBookGenreKey implements AbstractKey {
    private static final long serialVersionUID = 1L;

    private Long bookId;

    private Long genreId;

    @Override
    public Long[] ids() {
        return new Long[]{ bookId, genreId };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LnkBookGenreKey that = (LnkBookGenreKey) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genreId);
    }
}
