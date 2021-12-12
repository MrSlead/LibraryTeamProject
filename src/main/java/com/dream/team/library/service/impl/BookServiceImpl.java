package com.dream.team.library.service.impl;

import com.dream.team.library.dto.BookDto;
import com.dream.team.library.entity.lib.Book;
import com.dream.team.library.mapper.BookMapper;
import com.dream.team.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import com.dream.team.library.service.interf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        bookRepository.delete(BookMapper.INSTANCE.toBook(bookDto));
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
