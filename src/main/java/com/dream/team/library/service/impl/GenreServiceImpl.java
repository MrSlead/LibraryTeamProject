package com.dream.team.library.service.impl;

import com.dream.team.library.dto.GenreDto;
import com.dream.team.library.entity.lib.Genre;
import com.dream.team.library.mapper.GenreMapper;
import com.dream.team.library.repository.GenreRepository;
import com.dream.team.library.service.interf.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreDto> findAll() {
        List<Genre> genreList = genreRepository.findAll();

        log.info("Returned all genres");
        log.debug("Size of genres: " + genreList.size());

        return genreList.stream()
                .map(GenreMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GenreDto> findById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);

        if (genre.isPresent()) {
            log.info("Returned the genre by id: " + id);
            log.debug("Genre: " + genre.get());
        }
        else {
            log.info("Couldn't find the genre by id: " + id);

            return Optional.empty();
        }

        return Optional.of(GenreMapper.INSTANCE.toDTO(genre.get()));
    }

    @Override
    public Optional<GenreDto> save(GenreDto genreDto) {
        log.info("Saved the genre");
        log.debug("Genre: " + genreDto);

        if (genreDto == null || genreDto.getId() != null) {
            return Optional.empty();
        }

        Genre genre = genreRepository.save(GenreMapper.INSTANCE.toGenre(genreDto));
        return Optional.of(GenreMapper.INSTANCE.toDTO(genre));
    }

    @Override
    public Optional<GenreDto> update(GenreDto genreDto) {
        log.info("Updated the genre");
        log.debug("Genre: " + genreDto);

        if (genreDto == null || genreDto.getId() == null || genreRepository.findById(genreDto.getId()).isEmpty()) {
            return Optional.empty();
        }

        Genre genre = genreRepository.save(GenreMapper.INSTANCE.toGenre(genreDto));
        return Optional.of(GenreMapper.INSTANCE.toDTO(genre));
    }

    @Override
    public void delete(GenreDto genreDto) {
        log.info("Deleted the genre");
        log.debug("Genre: " + genreDto);

        genreRepository.delete(GenreMapper.INSTANCE.toGenre(genreDto));
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
