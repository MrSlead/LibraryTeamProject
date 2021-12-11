package com.dream.team.library.service.impl;

import com.dream.team.library.entity.lib.Language;
import com.dream.team.library.repository.LanguageRepository;
import com.dream.team.library.service.interf.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> findAll() {
        List<Language> languageList = languageRepository.findAll();

        log.info("Returned all languages");
        log.debug("Size of languages: " + languageList.size());

        return languageList;
    }

    @Override
    public Optional<Language> findById(Long id) {
        Optional<Language> language = languageRepository.findById(id);

        if (language.isPresent()) {
            log.info("Returned the language by id: " + id);
            log.debug("Language: " + language.get());
        }
        else {
            log.info("Couldn't find the language by id: " + id);
        }

        return language;
    }

    @Override
    public Language save(Language language) {
        log.info("Saved the language");
        log.debug("Language: " + language);

        return languageRepository.save(language);
    }

    @Override
    public Optional<Language> update(Language language) {
        log.info("Updated the language");
        log.debug("Language: " + language);

        if (language == null || language.getId() == null || languageRepository.findById(language.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(languageRepository.save(language));
    }

    @Override
    public void delete(Language language) {
        log.info("Deleted the language");
        log.debug("Language: " + language);

        languageRepository.delete(language);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Language> language = languageRepository.findById(id);

        if (language.isPresent()) {
            log.info("Deleted the language by id: " + id);
            log.debug("Language: " + language.get());
        }
        else {
            log.info("Couldn't find the language by id: " + id);
        }

        languageRepository.deleteById(id);
    }
}
