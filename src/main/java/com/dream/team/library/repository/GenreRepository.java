package com.dream.team.library.repository;

import com.dream.team.library.entity.lib.Book;
import com.dream.team.library.entity.lib.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends EntityRepository<Genre> {
    List<Genre> findAllByName(String name);
}
