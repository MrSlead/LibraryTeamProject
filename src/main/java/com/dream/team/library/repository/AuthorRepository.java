package com.dream.team.library.repository;

import com.dream.team.library.entity.lib.Author;
import com.dream.team.library.entity.lib.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends EntityRepository<Author> {
    List<Author> findAllByName(String name);
    List<Author> findAllBySurname(String surname);
    List<Author> findAllByPatronymic(String patronymic);
}
