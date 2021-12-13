package com.dream.team.library.config;

import com.dream.team.library.controller.AbstractBookDataController;
import com.dream.team.library.dto.BookDto;
import com.dream.team.library.service.impl.BookServiceImpl;
import com.dream.team.library.service.interf.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс AbstractBookDataControllerForBookConfig, необходимый для того, чтобы в объекте класса AbstractBookDataController
 * исплользовалась реализация BookServiceImpl.
 */
@Configuration
public class AbstractBookDataControllerForBookConfig {
    @Bean("AbstractBookDataControllerForBook")
    public AbstractBookDataController<BookDto> abstractBookDataController() {
        return new AbstractBookDataController<>(bookService());
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }
}
