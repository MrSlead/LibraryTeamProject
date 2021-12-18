package com.dream.team.library.service.impl;

import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.mapper.AuthorMapper;
import com.dream.team.library.repository.AuthorRepository;
import com.dream.team.library.service.interf.AuthorService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthorServiceImplTest {

    @MockBean
    private AuthorRepository authorRepository;

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Test
    void findByIdTest() {
        AuthorDto authorDto = new AuthorDto(1L, "Max", "Maxim", "Maximovich");

        when(authorRepository.findById(1L)).thenReturn(Optional.of(AuthorMapper.INSTANCE.toAuthor(authorDto)));

        Assert.assertEquals(authorDto, authorService.findById(1L).get());
        Assert.assertTrue(authorRepository.findById(2L).isEmpty());
    }
}