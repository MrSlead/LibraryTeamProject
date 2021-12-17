package com.dream.team.library.service.impl;

import com.dream.team.library.dto.BookDto;
import com.dream.team.library.entity.lib.Book;
import com.dream.team.library.mapper.BookMapper;
import com.dream.team.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import com.dream.team.library.service.interf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = bookRepository.findAll();

        log.info("Returned all books");
        log.debug("Size of books: " + bookList.size());

        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            log.info("Returned the book by id: " + id);
            log.debug("Book: " + book.get());
        }
        else {
            log.info("Couldn't find the genre by id: " + id);

            return Optional.empty();
        }

        return Optional.of(BookMapper.INSTANCE.toDTO(book.get()));
    }

    @Override
    public List<BookDto> findAllByName(String name) {
        log.info("Returned all books by name");

        if (name == null || name.isEmpty()) {
            return Collections.emptyList();
        }

        List<Book> bookList = bookRepository.findAllByName(name);

        log.debug("Size of books: " + bookList.size());


        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByLanguage(String language) {
        log.info("Returned all books by language");

        if (language == null || language.isEmpty()) {
            return Collections.emptyList();
        }

        List<Book> bookList = bookRepository.findAllByLanguage(language);

        log.debug("Size of books: " + bookList.size());

        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByNumberOfPages(Long numberOfPages) {
        log.info("Returned all books by number of pages");

        if (numberOfPages == null || numberOfPages <= 0) {
            return Collections.emptyList();
        }

        List<Book> bookList = bookRepository.findAllByNumberOfPages(numberOfPages);

        log.debug("Size of books: " + bookList.size());

        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByNumberOfPagesBetween(Long startNumber, Long endNumber) {
        log.info("Returned all books by number of pages between start number and end number");

        if (startNumber == null || endNumber == null || startNumber <= 0 || endNumber <= 0 || endNumber < startNumber) {
            return Collections.emptyList();
        }

        List<Book> bookList = bookRepository.findAllByNumberOfPagesBetween(startNumber, endNumber);

        log.debug("Size of books: " + bookList.size());

        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByDateOfPublication(Date date) {
        log.info("Returned all books by date of publication");

        if (date == null) {
            return Collections.emptyList();
        }

        List<Book> bookList = bookRepository.findAllByDateOfPublication(date);

        log.debug("Size of books: " + bookList.size());

        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findAllByDateOfPublicationBetween(Date startDate, Date endDate) {
        log.info("Returned all books by number of pages between start date and end date");

        if (startDate == null || endDate == null || startDate.getTime() - endDate.getTime() > 0) {
            return Collections.emptyList();
        }

        List<Book> bookList = bookRepository.findAllByDateOfPublicationBetween(startDate, endDate);

        log.debug("Size of books: " + bookList.size());

        return bookList.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> save(BookDto bookDto) {
        log.info("Saved the book");
        log.debug("Book: " + bookDto);

        if (bookDto == null || bookDto.getId() != null) {
            return Optional.empty();
        }

        Book book = bookRepository.save(BookMapper.INSTANCE.toBook(bookDto));
        return Optional.of(BookMapper.INSTANCE.toDTO(book));
    }

    @Override
    public Optional<BookDto> update(BookDto bookDto) {
        log.info("Updated the book");
        log.debug("Book: " + bookDto);

        if (bookDto == null || bookDto.getId() == null || bookRepository.findById(bookDto.getId()).isEmpty()) {
            return Optional.empty();
        }

        Book book = bookRepository.save(BookMapper.INSTANCE.toBook(bookDto));
        return Optional.of(BookMapper.INSTANCE.toDTO(book));
    }

    @Override
    public void delete(BookDto bookDto) {
        log.info("Deleted the book");
        log.debug("Book: " + bookDto);

        if (bookDto != null && bookDto.getId() != null) {
            bookRepository.delete(BookMapper.INSTANCE.toBook(bookDto));
        }
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
