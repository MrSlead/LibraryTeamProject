package com.dream.team.library.controller;

import com.dream.team.library.dto.BookDto;
import com.dream.team.library.payload.BookApiString;
import com.dream.team.library.service.interf.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
// Разрешение на получение данных только из указанного источника
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${book.api.begin}")
public class BookController {
    private AbstractController<BookDto> controller;
    private BookService bookService;
    private BookApiString bookApiString;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
        this.controller = new AbstractController<>(bookService);
    }

    @Autowired
    public void setBookApiString(BookApiString bookApiString) {
        this.bookApiString = bookApiString;
    }

    @GetMapping("${book.api.getById}")
    public ResponseEntity<Optional<BookDto>> getClientById(@PathVariable Long bookId) {
        log.info("API was called: {}", bookApiString.getBookApiUpdate());

        return controller.getObjectById(bookId);
    }

    @GetMapping("${book.api.getAll}")
    public ResponseEntity<List<BookDto>> getAll() {
        log.info("API was called: {}", bookApiString.getBookApiGetAll());

        return controller.getAll();
    }

    @PostMapping(value = "${book.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiSave());

        return controller.save(bookDto);
    }

    @PutMapping(value = "${book.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiSave());

        return controller.update(bookDto);
    }

    @DeleteMapping(value = "${book.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiDelete());

        if (bookDto != null && bookDto.getId() != null) {
            bookService.delete(bookDto);
        }
    }

    @DeleteMapping(value = "${book.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long bookId) {
        log.info("API was called: {}", bookApiString.getBookApiDeleteById());

        controller.deleteById(bookId);
    }
}
