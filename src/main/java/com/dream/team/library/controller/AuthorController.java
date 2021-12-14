package com.dream.team.library.controller;

import com.dream.team.library.dto.AuthorDto;
import com.dream.team.library.dto.BookDto;
import com.dream.team.library.payload.AuthorApiString;
import com.dream.team.library.service.interf.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Author", description = "The Author API")
@Slf4j
@RestController
// Разрешение на получение данных только из указанного источника
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${author.api.begin}")
public class AuthorController {
    private AbstractController<AuthorDto> controller;
    private AuthorService authorService;
    private AuthorApiString authorApiString;

    @Qualifier("AbstractBookDataControllerForAuthor")
    @Autowired
    public void setController(AbstractController<AuthorDto> controller) {
        this.controller = controller;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Autowired
    public void setGenreApiString(AuthorApiString authorApiString) {
        this.authorApiString = authorApiString;
    }

    @Operation(summary = "Get author by id", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the author by id",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthorDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parameter authorId is null",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The author by id not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${author.api.getById}")
    public ResponseEntity<Optional<AuthorDto>> getAuthorById(@PathVariable Long authorId) {
        log.info("API was called: {}", authorApiString.getAuthorApiGetById());

        return controller.getObjectById(authorId);
    }

    @Operation(summary = "Gets all authors", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the authors",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AuthorDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${author.api.getAll}")
    public ResponseEntity<List<AuthorDto>> getAll() {
        log.info("API was called: {}", authorApiString.getAuthorApiGetAll());

        return controller.getAll();
    }

    @Operation(summary = "Gets all authors by name", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the authors",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AuthorDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${author.api.getAllByName}")
    public ResponseEntity<List<AuthorDto>> getAllByName(@PathVariable String name) {
        log.info("API was called: {}", authorApiString.getAuthorApiGetAllByName());

        return ((AbstractBookDataController<AuthorDto>) controller).getAllByName(name);
    }

    @Operation(summary = "Gets all authors by surname", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the authors",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AuthorDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${author.api.getAllBySurname}")
    public ResponseEntity<List<AuthorDto>> getAllBySurname(@PathVariable String surname) {
        log.info("API was called: {}", authorApiString.getAuthorApiGetAllBySurname());

        List<AuthorDto> authorList = authorService.findAllBySurname(surname);

        if (authorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @Operation(summary = "Gets all authors by patronymic", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the authors",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AuthorDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The passed object is null, or is empty",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping("${author.api.getAllByPatronymic}")
    public ResponseEntity<List<AuthorDto>> getAllByPatronymic(@PathVariable String patronymic) {
        log.info("API was called: {}", authorApiString.getAuthorApiGetAllByPatronymic());

        List<AuthorDto> authorList = authorService.findAllByPatronymic(patronymic);

        if (authorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @Operation(summary = "Saving the author", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Saved the author",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthorDto.class)
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
    @PostMapping(value = "${author.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto) {
        log.info("API was called: {}", authorApiString.getAuthorApiSave());

        if (authorDto == null || authorDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return controller.save(authorDto);
    }

    @Operation(summary = "Updating the author", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated the author",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthorDto.class)
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
    @PutMapping(value = "${author.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto authorDto) {
        log.info("API was called: {}", authorApiString.getAuthorApiUpdate());

        return controller.update(authorDto);
    }

    @Operation(summary = "Deleting the author", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the author"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${author.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody AuthorDto authorDto) {
        log.info("API was called: {}", authorApiString.getAuthorApiDelete());

        controller.delete(authorDto);
    }

    @Operation(summary = "Deleting the author by id", tags = "author")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the author by id"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${author.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long authorId) {
        log.info("API was called: {}", authorApiString.getAuthorApiDeleteById());

        controller.deleteById(authorId);
    }
}
