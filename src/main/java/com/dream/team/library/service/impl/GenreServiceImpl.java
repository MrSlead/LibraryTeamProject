package com.dream.team.library.service.impl;

import com.dream.team.library.entity.lib.Genre;
import com.dream.team.library.repository.GenreRepository;
import com.dream.team.library.service.interf.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genreList = genreRepository.findAll();

        log.info("Returned all genres");
        log.debug("Size of genres: " + genreList.size());

        return genreList;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);

        if (genre.isPresent()) {
            log.info("Returned the genre by id: " + id);
            log.debug("Genre: " + genre.get());
        }
        else {
            log.info("Couldn't find the genre by id: " + id);
        }

        return genre;
    }

    @Override
    public Optional<Genre> save(Genre genre) {
        log.info("Saved the genre");
        log.debug("Genre: " + genre);

        if (genre == null || genre.getId() != null) {
            return Optional.empty();
        }

        return Optional.of(genreRepository.save(genre));
    }

    @Override
    public Optional<Genre> update(Genre genre) {
        log.info("Updated the genre");
        log.debug("Genre: " + genre);

        if (genre == null || genre.getId() == null || genreRepository.findById(genre.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(genreRepository.save(genre));
    }

    @Override
    public void delete(Genre genre) {
        log.info("Deleted the genre");
        log.debug("Genre: " + genre);

        genreRepository.delete(genre);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);

        if (genre.isPresent()) {
            log.info("Deleted the genre by id: " + id);
            log.debug("Genre: " + genre.get());
        }
        else {
            log.info("Couldn't find the genre by id: " + id);
        }

        genreRepository.deleteById(id);
    }
}
