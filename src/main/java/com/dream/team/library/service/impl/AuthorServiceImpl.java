package com.dream.team.library.service.impl;

import com.dream.team.library.entity.lib.Author;
import com.dream.team.library.repository.AuthorRepository;
import com.dream.team.library.service.interf.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authorList = authorRepository.findAll();

        log.info("Returned all authors");
        log.debug("Size of authors: " + authorList.size());

        return authorList;
    }

    @Override
    public Optional<Author> findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            log.info("Returned the author by id: " + id);
            log.debug("Author: " + author.get());
        }
        else {
            log.info("Couldn't find the author by id: " + id);
        }

        return author;
    }

    @Override
    public Optional<Author> save(Author author) {
        log.info("Saved the author");
        log.debug("Author: " + author);

        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void delete(Author author) {
        log.info("Deleted the author");
        log.debug("Author: " + author);

        authorRepository.delete(author);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            log.info("Deleted the author by id: " + id);
            log.debug("Author: " + author.get());
        }
        else {
            log.info("Couldn't find the author by id: " + id);
        }

        authorRepository.deleteById(id);
    }
}
