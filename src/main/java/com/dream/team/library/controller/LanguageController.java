package com.dream.team.library.controller;

import com.dream.team.library.dto.LanguageDto;
import com.dream.team.library.payload.LanguageApiString;
import com.dream.team.library.service.interf.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AbstractController<LanguageDto> controller;
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
    public ResponseEntity<Optional<LanguageDto>> getClientById(@PathVariable Long languageId) {
        log.info("API was called: {}", languageApiString.getLanguageApiGetById());

        return controller.getObjectById(languageId);
    }

    @GetMapping("${language.api.getAll}")
    public ResponseEntity<List<LanguageDto>> getAll() {
        log.info("API was called: {}", languageApiString.getLanguageApiGetAll());

        return controller.getAll();
    }

    @PostMapping(value = "${language.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageDto> save(@RequestBody LanguageDto languageDto) {
        log.info("API was called: {}", languageApiString.getLanguageApiSave());

        return controller.save(languageDto);
    }

    @PutMapping(value = "${language.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageDto> update(@RequestBody LanguageDto languageDto) {
        log.info("API was called: {}", languageApiString.getLanguageApiUpdate());

        return controller.update(languageDto);
    }

    @DeleteMapping(value = "${language.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody LanguageDto languageDto) {
        log.info("API was called: {}", languageApiString.getLanguageApiDelete());

        if (languageDto != null && languageDto.getId() != null) {
            languageService.delete(languageDto);
        }
    }

    @DeleteMapping(value = "${language.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long languageId) {
        log.info("API was called: {}", languageApiString.getLanguageApiDeleteById());

        controller.deleteById(languageId);
    }
}
