package com.dream.team.library.repository;

import com.dream.team.library.entity.lib.Book;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends EntityRepository<Book> {
    List<Book> findAllByName(String name);
    List<Book> findAllByLanguage(String language);
    List<Book> findAllByNumberOfPages(Long number);
    List<Book> findAllByNumberOfPagesBetween(Long startNumber, Long endNumber);
    List<Book> findAllByDateOfPublication(Date date);
    List<Book> findAllByDateOfPublicationBetween(Date startDate, Date endDate);
}
