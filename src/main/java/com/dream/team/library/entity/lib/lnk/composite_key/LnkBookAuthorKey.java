package com.dream.team.library.entity.lib.lnk.composite_key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

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
}
