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
public class LnkBookAuthorKey implements AbstractKey {
    private static final long serialVersionUID = 1L;

    private Long bookId;

    private Long authorId;

    @Override
    public Long[] ids() {
        return new Long[]{ bookId, authorId };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LnkBookAuthorKey that = (LnkBookAuthorKey) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, authorId);
    }
}
