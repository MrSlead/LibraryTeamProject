package com.dream.team.library.config;

import com.dream.team.library.controller.AbstractBookDataController;
import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.dto.BookDto;
import com.dream.team.library.dto.GenreDto;
import com.dream.team.library.dto.LanguageDto;
import com.dream.team.library.service.impl.AuthorServiceImpl;
import com.dream.team.library.service.impl.BookServiceImpl;
import com.dream.team.library.service.impl.GenreServiceImpl;
import com.dream.team.library.service.impl.LanguageServiceImpl;
import com.dream.team.library.service.interf.AuthorService;
import com.dream.team.library.service.interf.BookService;
import com.dream.team.library.service.interf.GenreService;
import com.dream.team.library.service.interf.LanguageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс AbstractBookDataControllerConfig, необходимый для того, чтобы в объекте класса AbstractBookDataController
 * исплользовалась соответствующая реализация.
 */
@Configuration
public class AbstractBookDataControllerConfig {
    @Bean("AbstractBookDataControllerForBook")
    public AbstractBookDataController<BookDto> abstractBookDataControllerForBook() {
        return new AbstractBookDataController<>(bookService());
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }

//---------------------------

    @Bean("AbstractBookDataControllerForAuthor")
    public AbstractBookDataController<AuthorDto> abstractBookDataControllerForAuthor() {
        return new AbstractBookDataController<>(authorService());
    }

    @Bean
    public AuthorService authorService() {
        return new AuthorServiceImpl();
    }

//--------------------------

    @Bean("AbstractBookDataControllerForGenre")
    public AbstractBookDataController<GenreDto> abstractBookDataControllerForGenre() {
        return new AbstractBookDataController<>(genreService());
    }

    @Bean
    public GenreService genreService() {
        return new GenreServiceImpl();
    }

//--------------------------

    @Bean("AbstractBookDataControllerForLanguage")
    public AbstractBookDataController<LanguageDto> abstractBookDataControllerForLanguage() {
        return new AbstractBookDataController<>(languageService());
    }

    @Bean
    public LanguageService languageService() {
        return new LanguageServiceImpl();
    }
}
