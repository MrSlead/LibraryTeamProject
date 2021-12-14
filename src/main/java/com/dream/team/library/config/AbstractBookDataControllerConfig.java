package com.dream.team.library.config;

import com.dream.team.library.controller.AbstractBookDataController;
import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.dto.BookDto;
import com.dream.team.library.service.impl.AuthorServiceImpl;
import com.dream.team.library.service.impl.BookServiceImpl;
import com.dream.team.library.service.interf.AuthorService;
import com.dream.team.library.service.interf.BookService;
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


    @Bean("AbstractBookDataControllerForAuthor")
    public AbstractBookDataController<AuthorDto> abstractBookDataControllerForAuthor() {
        return new AbstractBookDataController<>(authorService());
    }

    @Bean
    public AuthorService authorService() {
        return new AuthorServiceImpl();
    }
}
