package com.dream.team.library.controller;

import com.dream.team.library.entity.lib.Language;
import com.dream.team.library.payload.LanguageApiString;
import com.dream.team.library.service.interf.LanguageService;
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
// Разрешение на получение данных только из указанного источника.
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${language.api.begin}")
public class LanguageController {
    private AbstractController<Language> controller;
    private LanguageService languageService;
    private LanguageApiString languageApiString;

    @Autowired
    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
        this.controller = new AbstractController<>(languageService);
    }

    @Autowired
    public void setGenreApiString(LanguageApiString genreApiString) {
        this.languageApiString = genreApiString;
    }

    @GetMapping("${language.api.getById}")
    public ResponseEntity<Optional<Language>> getClientById(@PathVariable Long languageId) {
        log.info("API was called: {}", languageApiString.getLanguageApiGetById());

        return controller.getObjectById(languageId);
    }

    @GetMapping("${language.api.getAll}")
    public ResponseEntity<List<Language>> getAll() {
        log.info("API was called: {}", languageApiString.getLanguageApiGetAll());

        return controller.getAll();
    }

    @PostMapping(value = "${language.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> save(@RequestBody Language language) {
        log.info("API was called: {}", languageApiString.getLanguageApiSave());

        if (language == null || language.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return controller.save(language);
    }

    @PutMapping(value = "${language.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> update(@RequestBody Language language) {
        log.info("API was called: {}", languageApiString.getLanguageApiUpdate());

        return controller.update(language);
    }

    @DeleteMapping(value = "${language.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Language language) {
        log.info("API was called: {}", languageApiString.getLanguageApiDelete());

        if (language != null && language.getId() != null) {
            languageService.delete(language);
        }
    }

    @DeleteMapping(value = "${language.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long languageId) {
        log.info("API was called: {}", languageApiString.getLanguageApiDeleteById());

        controller.deleteById(languageId);
    }
}
