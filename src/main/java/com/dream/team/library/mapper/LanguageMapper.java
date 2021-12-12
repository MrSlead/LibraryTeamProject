package com.dream.team.library.mapper;

import com.dream.team.library.dto.LanguageDto;
import com.dream.team.library.entity.lib.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    LanguageDto toDTO(Language language);
    Language toLanguage(LanguageDto languageDto);
}
