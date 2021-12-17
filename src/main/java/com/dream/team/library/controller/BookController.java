package com.dream.team.library.controller;

import com.dream.team.library.controller.api.ApiResult;
import com.dream.team.library.controller.api.ApiResultError;
import com.dream.team.library.controller.helper.ExampleObjectHelper;
import com.dream.team.library.dto.BookDto;
import com.dream.team.library.payload.BookApiString;
import com.dream.team.library.service.interf.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @Qualifier("AbstractBookDataControllerForBook")
    @Autowired
    public void setController(AbstractController<BookDto> controller) {
        this.controller = controller;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setBookApiString(BookApiString bookApiString) {
        this.bookApiString = bookApiString;
    }

    @Operation(summary = "Get book by id", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the book by id"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed parameter is null",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetById.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The object by id not found",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetById.CODE_404)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<Optional<BookDto>> getBookById(@PathVariable Long bookId) {
        log.info("API was called: {}", bookApiString.getBookApiGetById());

        return controller.getObjectById(bookId);
    }

    @Operation(summary = "Gets all books", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAll}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAll() {
        log.info("API was called: {}", bookApiString.getBookApiGetAll());

        return controller.getAll();
    }

    @Operation(summary = "Gets all books by name", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books by name"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetAllBy.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAllByName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAllByName(@PathVariable String name) {
        log.info("API was called: {}", bookApiString.getBookApiGetAllByName());

        return ((AbstractBookDataController<BookDto>) controller).getAllByName(name);
    }

    @Operation(summary = "Gets all books by language", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books by name"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetAllBy.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAllByLanguage}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAllByLanguage(@PathVariable String language) {
        log.info("API was called: {}", bookApiString.getBookApiGetAllByLanguage());

        List<BookDto> bookList = bookService.findAllByLanguage(language);
        if (bookList.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or is empty"));
        }

        return ApiResult.success(bookList);
    }

    @Operation(summary = "Gets all books by number of pages", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books by name"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetAllBy.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAllByNumberOfPages}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAllByNumberOfPages(@PathVariable Long numberOfPages) {
        log.info("API was called: {}", bookApiString.getBookApiGetAllByNumberOfPages());

        List<BookDto> bookList = bookService.findAllByNumberOfPages(numberOfPages);
        if (bookList.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or is empty"));
        }

        return ApiResult.success(bookList);
    }

    @Operation(summary = "Gets all books by number of pages between start number and end number", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books by name"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetAllBy.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAllByNumberOfPagesBetween}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAllByNumberOfPagesBetween(@RequestParam Long startNumber,
                                                                      @RequestParam Long endNumber)
    {
        log.info("API was called: {}", bookApiString.getBookApiGetAllByNumberOfPagesBetween());

        List<BookDto> bookList = bookService.findAllByNumberOfPagesBetween(startNumber, endNumber);
        if (bookList.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or is empty"));
        }

        return ApiResult.success(bookList);
    }

    @Operation(summary = "Gets all books by date of publication", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books by name"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetAllBy.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAllByDateOfPublication}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAllByDateOfPublication(@PathVariable Date date) {
        log.info("API was called: {}", bookApiString.getBookApiGetAllByNumberOfPages());

        List<BookDto> bookList = bookService.findAllByDateOfPublication(date);
        if (bookList.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or is empty"));
        }

        return ApiResult.success(bookList);
    }

    @Operation(summary = "Gets all books by date of publication between start date and end date", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the books by name"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.GetAllBy.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${book.api.getAllByDateOfPublicationBetween}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<BookDto>> getAllByDateOfPublicationBetween(@RequestParam Date startDate,
                                                                          @RequestParam Date endDate) {
        log.info("API was called: {}", bookApiString.getBookApiGetAllByNumberOfPagesBetween());

        List<BookDto> bookList = bookService.findAllByDateOfPublicationBetween(startDate, endDate);
        if (bookList.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or is empty"));
        }

        return ApiResult.success(bookList);
    }


    @Operation(summary = "Saving the book", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved the book"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or it has id",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.Save.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @PostMapping(value = "${book.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<BookDto> save(@RequestBody BookDto bookDto) {
        log.info("API was called: {}", bookApiString.getBookApiSave());

        return controller.save(bookDto);
    }

    @Operation(summary = "Updating the book", tags = "book")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated the book"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or it has no id, or it not contained in the database",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(value = ExampleObjectHelper.Update.CODE_400)}
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @PutMapping(value = "${book.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<BookDto> update(@RequestBody BookDto bookDto) {
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

        controller.delete(bookDto);
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
