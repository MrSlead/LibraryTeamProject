package com.dream.team.library.service.impl;

import com.dream.team.library.dto.LanguageDto;
import com.dream.team.library.entity.lib.Language;
import com.dream.team.library.mapper.LanguageMapper;
import com.dream.team.library.repository.LanguageRepository;
import com.dream.team.library.service.interf.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDto> findAll() {
        List<Language> languageList = languageRepository.findAll();

        log.info("Returned all languages");
        log.debug("Size of languages: " + languageList.size());

        return languageList.stream()
                .map(LanguageMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LanguageDto> findById(Long id) {
        Optional<Language> language = languageRepository.findById(id);

        if (language.isPresent()) {
            log.info("Returned the language by id: " + id);
            log.debug("Language: " + language.get());
        }
        else {
            log.info("Couldn't find the language by id: " + id);

            return Optional.empty();
        }

        return Optional.of(LanguageMapper.INSTANCE.toDTO(language.get()));
    }

    @Override
    public Optional<LanguageDto> save(LanguageDto languageDto) {
        log.info("Saved the language");
        log.debug("Language: " + languageDto);

        if (languageDto == null || languageDto.getId() != null) {
            return Optional.empty();
        }

        Language language = languageRepository.save(LanguageMapper.INSTANCE.toLanguage(languageDto));
        return Optional.of(LanguageMapper.INSTANCE.toDTO(language));
    }

    @Override
    public Optional<LanguageDto> update(LanguageDto languageDto) {
        log.info("Updated the language");
        log.debug("Language: " + languageDto);

        if (languageDto == null || languageDto.getId() == null || languageRepository.findById(languageDto.getId()).isEmpty()) {
            return Optional.empty();
        }

        Language language = languageRepository.save(LanguageMapper.INSTANCE.toLanguage(languageDto));
        return Optional.of(LanguageMapper.INSTANCE.toDTO(language));
    }

    @Override
    public void delete(LanguageDto languageDto) {
        log.info("Deleted the language");
        log.debug("Language: " + languageDto);

        if (languageDto != null && languageDto.getId() != null) {
            languageRepository.delete(LanguageMapper.INSTANCE.toLanguage(languageDto));
        }
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
