package com.dream.team.library.service.interf;

import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.entity.lib.Author;

import java.util.List;

public interface AuthorService extends AbstractBookDataService<AuthorDto, Long> {
    List<AuthorDto> findAllBySurname(String surname);
    List<AuthorDto> findAllByPatronymic(String patronymic);
}
