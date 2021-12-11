package com.dream.team.library.service.impl;

import com.dream.team.library.entity.lib.Book;
import com.dream.team.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import com.dream.team.library.service.interf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findAll();

        log.info("Returned all books");
        log.debug("Size of books: " + bookList.size());

        return bookList;
    }

    @Override
    public Optional<Book> findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            log.info("Returned the book by id: " + id);
            log.debug("Book: " + book.get());
        }
        else {
            log.info("Couldn't find the genre by id: " + id);
        }

        return book;
    }

    @Override
    public Book save(Book book) {
        log.info("Saved the book");
        log.debug("Book: " + book);

        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Book book) {
        log.info("Updated the book");
        log.debug("Book: " + book);

        if (book == null || book.getId() == null || bookRepository.findById(book.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void delete(Book book) {
        log.info("Deleted the book");
        log.debug("Book: " + book);

        bookRepository.delete(book);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            log.info("Deleted the book by id: " + id);
            log.debug("Book: " + book.get());
        }
        else {
            log.info("Couldn't find the book by id: " + id);
        }

        bookRepository.deleteById(id);
    }
}
