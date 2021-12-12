package com.dream.team.library.mapper;

import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.entity.lib.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto toDTO(Author author);
    Author toAuthor(AuthorDto authorDto);
}
