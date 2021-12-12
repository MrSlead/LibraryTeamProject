package com.dream.team.library.mapper;

import com.dream.team.library.dto.GenreDto;
import com.dream.team.library.entity.lib.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDto toDTO(Genre genre);
    Genre toGenre(GenreDto genreDto);
}
