package com.dream.team.library.mapper;

import com.dream.team.library.dto.BookDto;
import com.dream.team.library.entity.lib.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDTO(Book book);
    Book toBook(BookDto bookDto);
}
