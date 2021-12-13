package com.dream.team.library.dto;

import com.dream.team.library.entity.lib.Language;
import com.dream.team.library.entity.lib.converter.BookFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookDto {
    private Long id;
    private String name;
    private Date dateOfPublication;
    private Language language;
    private int numberOfPages;
    private BookFormat bookFormat;
}
