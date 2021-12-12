package com.dream.team.library.controller;

import com.dream.team.library.dto.BookDto;
import com.dream.team.library.payload.BookApiString;
import com.dream.team.library.service.interf.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Book", description = "The Book API")
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

    @Operation(summary = "Get book by id", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the book by id",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parameter bookId is null",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The book by id not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${book.api.getById}")
    public ResponseEntity<Optional<BookDto>> getBookById(@PathVariable Long bookId) {
        log.info("API was called: {}", bookApiString.getBookApiUpdate());

        return controller.getObjectById(bookId);
    }

    @Operation(summary = "Gets all books", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BookDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${book.api.getAll}")
    public ResponseEntity<List<BookDto>> getAll() {
        log.info("API was called: {}", bookApiString.getBookApiGetAll());

        return controller.getAll();
    }

    @Operation(summary = "Saving the book", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Saved the book",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or it has id",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @PostMapping(value = "${book.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiSave());

        return controller.save(bookDto);
    }

    @Operation(summary = "Updating the book", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated the book",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or it has no id, or it not contained in the database",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @PutMapping(value = "${book.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiSave());

        return controller.update(bookDto);
    }

    @Operation(summary = "Deleting the book", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the book"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${book.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiDelete());

        if (bookDto != null && bookDto.getId() != null) {
            bookService.delete(bookDto);
        }
    }

    @Operation(summary = "Deleting the book by id", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the book by id"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${book.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long bookId) {
        log.info("API was called: {}", bookApiString.getBookApiDeleteById());

        controller.deleteById(bookId);
    }
}
