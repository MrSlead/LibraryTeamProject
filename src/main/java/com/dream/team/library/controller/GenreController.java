package com.dream.team.library.controller;

import com.dream.team.library.dto.GenreDto;
import com.dream.team.library.entity.lib.Genre;
import com.dream.team.library.payload.GenreApiString;
import com.dream.team.library.service.interf.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
// Разрешение на получение данных только из указанного источника
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${genre.api.begin}")
public class GenreController {
    private AbstractController<GenreDto> controller;
    private GenreService genreService;
    private GenreApiString genreApiString;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
        this.controller = new AbstractController<>(genreService);
    }

    @Autowired
    public void setGenreApiString(GenreApiString genreApiString) {
        this.genreApiString = genreApiString;
    }

    @GetMapping("${genre.api.getById}")
    public ResponseEntity<Optional<GenreDto>> getClientById(@PathVariable Long genreId) {
        log.info("API was called: {}", genreApiString.getGenreApiGetById());

        return controller.getObjectById(genreId);
    }

    @GetMapping("${genre.api.getAll}")
    public ResponseEntity<List<GenreDto>> getAll() {
        log.info("API was called: {}", genreApiString.getGenreApiGetAll());

        return controller.getAll();
    }

    @PostMapping(value = "${genre.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDto> save(@RequestBody GenreDto genreDto) {
        log.info("API was called: {}", genreApiString.getGenreApiSave());

        return controller.save(genreDto);
    }

    @PutMapping(value = "${genre.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDto> update(@RequestBody GenreDto genreDto) {
        log.info("API was called: {}", genreApiString.getGenreApiUpdate());

        return controller.update(genreDto);
    }

    @DeleteMapping(value = "${genre.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody GenreDto genreDto) {
        log.info("API was called: {}", genreApiString.getGenreApiDelete());

        if (genreDto != null && genreDto.getId() != null) {
            genreService.delete(genreDto);
        }
    }

    @DeleteMapping(value = "${genre.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long genreId) {
        log.info("API was called: {}", genreApiString.getGenreApiDeleteById());

        controller.deleteById(genreId);
    }
}
