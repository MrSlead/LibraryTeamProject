package com.dream.team.library.controller;

import com.dream.team.library.entity.lib.Author;
import com.dream.team.library.repository.AuthorRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class AuthorControllerTest {

    @MockBean
    private AuthorRepository authorRepository;

    @Autowired
    private MockMvc mockMvc;

    private Author author1 = new Author(1L, "Pushkin", "Alexander", "Sergeevich");
    private Author author2 = new Author(2L, "Chekhov", "Anton", "Pavlovich");
    private Author author3 = new Author(3L, "Dostoevsky", "Fedor", "Mikhailovich");

    @SneakyThrows
    @Test
    void getAll() {
        String surname = "Dostoevsky";
        String uri = "/api/v1/author/all";
        List authorList = List.of(author1, author2, author3);

        Mockito.when(authorRepository.findAll()).thenReturn(authorList);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].surname", is(surname)));
    }

    @SneakyThrows
    @Test
    void getAuthorById() {
        String surname = "Pushkin";
        String uri = "/api/v1/author/id/1";
        Mockito.when(authorRepository.findById(1L)).thenReturn(Optional.of(author1));

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.surname", is(surname)));
    }

    @SneakyThrows
    @Test
    void getAllByName() {
        String name = "Alexander";
        String uri = "/api/v1/author/name/" + name;
        List authorList = List.of(author1);

        Mockito.when(authorRepository.findAllByName(name)).thenReturn(authorList);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(name)));



        List authorList2 = List.of(author1, new Author(4L, "Ivanov", "Alexander", "P"));

        Mockito.when(authorRepository.findAllByName(name)).thenReturn(authorList2);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(name)))
                .andExpect(jsonPath("$[1].name", is(name)));

    }

    @SneakyThrows
    @Test
    void getAllBySurname() {
        String surname = "Pushkin";
        String uri = "/api/v1/author/surname/" + surname;
        List authorList = List.of(author1);

        Mockito.when(authorRepository.findAllBySurname(surname)).thenReturn(authorList);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].surname", is(surname)));




        List authorList2 = List.of(author1, new Author(4L, "Pushkin", "Evgeniy", "Sergeevich"));

        Mockito.when(authorRepository.findAllBySurname(surname)).thenReturn(authorList2);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].surname", is(surname)))
                .andExpect(jsonPath("$[1].surname", is(surname)));
    }

    @SneakyThrows
    @Test
    void getAllByPatronymic() {
        String patronymic = "Sergeevich";
        String uri = "/api/v1/author/patronymic/" + patronymic;
        List authorList = List.of(author1);

        Mockito.when(authorRepository.findAllByPatronymic(patronymic)).thenReturn(authorList);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].patronymic", is(patronymic)));




        List authorList2 = List.of(author1, new Author(4L, "Pushkin", "Evgeniy", "Sergeevich"));

        Mockito.when(authorRepository.findAllByPatronymic(patronymic)).thenReturn(authorList2);

        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].patronymic", is(patronymic)))
                .andExpect(jsonPath("$[1].patronymic", is(patronymic)));
    }
}