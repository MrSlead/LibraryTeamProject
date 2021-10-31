package com.dream.team.library.repository;

import com.dream.team.library.entity.lib.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends EntityRepository<Book> {
}
