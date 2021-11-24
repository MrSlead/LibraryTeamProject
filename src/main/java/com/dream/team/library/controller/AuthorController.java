package com.dream.team.library.controller;

import com.dream.team.library.entity.lib.Author;
import com.dream.team.library.payload.AuthorApiString;
import com.dream.team.library.service.interf.AuthorService;
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
@RequestMapping("${author.api.begin}")
public class AuthorController {
    private AbstractController<Author> controller;
    private AuthorService authorService;
    private AuthorApiString authorApiString;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
        this.controller = new AbstractController<>(authorService);
    }

    @Autowired
    public void setGenreApiString(AuthorApiString authorApiString) {
        this.authorApiString = authorApiString;
    }

    @GetMapping("${author.api.getById}")
    public ResponseEntity<Optional<Author>> getClientById(@PathVariable Long authorId) {
        log.info("API was called: {}", authorApiString.getAuthorApiGetById());

        return controller.getObjectById(authorId);
    }

    @GetMapping("${author.api.getAll}")
    public ResponseEntity<List<Author>> getAll() {
        log.info("API was called: {}", authorApiString.getAuthorApiGetAll());

        return controller.getAll();
    }

    @PostMapping(value = "${author.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> save(@RequestBody Author author) {
        log.info("API was called: {}", authorApiString.getAuthorApiSave());

        if (author == null || author.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return controller.save(author);
    }

    @DeleteMapping(value = "${author.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Author author) {
        log.info("API was called: {}", authorApiString.getAuthorApiDelete());

        if (author != null && author.getId() != null) {
            authorService.delete(author);
        }
    }

    @DeleteMapping(value = "${author.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@RequestBody Long authorId) {
        log.info("API was called: {}", authorApiString.getAuthorApiDeleteById());

        controller.deleteById(authorId);
    }
}
