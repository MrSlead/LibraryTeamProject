package com.dream.team.library.service.interf;

import com.dream.team.library.dto.BookDto;
import java.util.Date;
import java.util.List;

public interface BookService extends AbstractBookDataService<BookDto, Long> {
    List<BookDto> findAllByLanguage(String language);
    List<BookDto> findAllByNumberOfPages(Long number);
    List<BookDto> findAllByNumberOfPagesBetween(Long startNumber, Long endNumber);
    List<BookDto> findAllByDateOfPublication(Date date);
    List<BookDto> findAllByDateOfPublicationBetween(Date startDate, Date endDate);
}
