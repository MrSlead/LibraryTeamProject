package com.dream.team.library.service.impl;

import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.entity.lib.Author;
import com.dream.team.library.mapper.AuthorMapper;
import com.dream.team.library.repository.AuthorRepository;
import com.dream.team.library.service.interf.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authorList = authorRepository.findAll();

        log.info("Returned all authors");
        log.debug("Size of authors: " + authorList.size());

        return authorList.stream()
                .map(AuthorMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorDto> findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            log.info("Returned the author by id: " + id);
            log.debug("Author: " + author.get());
        }
        else {
            log.info("Couldn't find the author by id: " + id);

            return Optional.empty();
        }

        return Optional.of(AuthorMapper.INSTANCE.toDTO(author.get()));
    }

    @Override
    public Optional<AuthorDto> save(AuthorDto authorDto) {
        log.info("Saved the author");
        log.debug("Author: " + authorDto);

        if (authorDto == null || authorDto.getId() != null) {
            return Optional.empty();
        }

        Author author = authorRepository.save(AuthorMapper.INSTANCE.toAuthor(authorDto));
        return Optional.of(AuthorMapper.INSTANCE.toDTO(author));
    }

    @Override
    public Optional<AuthorDto> update(AuthorDto authorDto) {
        log.info("Updated the author");
        log.debug("Author: " + authorDto);

        if (authorDto == null || authorDto.getId() == null || authorRepository.findById(authorDto.getId()).isEmpty()) {
            return Optional.empty();
        }

        Author author = authorRepository.save(AuthorMapper.INSTANCE.toAuthor(authorDto));
        return Optional.of(AuthorMapper.INSTANCE.toDTO(author));
    }

    @Override
    public void delete(AuthorDto authorDto) {
        log.info("Deleted the author");
        log.debug("Author: " + authorDto);

        authorRepository.delete(AuthorMapper.INSTANCE.toAuthor(authorDto));
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
