package com.dream.team.library.controller;

import com.dream.team.library.controller.api.ApiResult;
import com.dream.team.library.controller.helper.ExampleObjectHelper;
import com.dream.team.library.dto.GenreDto;
import com.dream.team.library.payload.GenreApiString;
import com.dream.team.library.service.interf.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Genre", description = "The Genre API")
@Slf4j
@RestController
// Разрешение на получение данных только из указанного источника
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${genre.api.begin}")
public class GenreController {
    private AbstractController<GenreDto> controller;
    private GenreService genreService;
    private GenreApiString genreApiString;

    @Qualifier("AbstractBookDataControllerForGenre")
    @Autowired
    public void setController(AbstractController<GenreDto> controller) {
        this.controller = controller;
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setGenreApiString(GenreApiString genreApiString) {
        this.genreApiString = genreApiString;
    }

    @Operation(summary = "Get genre by id", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the genre by id"
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
    @GetMapping(value = "${genre.api.getById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<Optional<GenreDto>> getGenreById(@PathVariable Long genreId) {
        log.info("API was called: {}", genreApiString.getGenreApiGetById());

        return controller.getObjectById(genreId);
    }

    @Operation(summary = "Gets all genres", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the genres"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${genre.api.getAll}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<GenreDto>> getAll() {
        log.info("API was called: {}", genreApiString.getGenreApiGetAll());

        return controller.getAll();
    }

    @Operation(summary = "Gets all genres by name", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the genres"
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
    @GetMapping(value = "${genre.api.getAllByName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<GenreDto>> getAllByName(@PathVariable String name) {
        log.info("API was called: {}", genreApiString.getGenreApiGetAllByName());

        return ((AbstractBookDataController<GenreDto>) controller).getAllByName(name);
    }

    @Operation(summary = "Saving the genre", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved the genre"
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
    @PostMapping(value = "${genre.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<GenreDto> save(@RequestBody GenreDto genreDto) {
        log.info("API was called: {}", genreApiString.getGenreApiSave());

        return controller.save(genreDto);
    }

    @Operation(summary = "Updating the genre", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated the genre"
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
    @PutMapping(value = "${genre.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<GenreDto> update(@RequestBody GenreDto genreDto) {
        log.info("API was called: {}", genreApiString.getGenreApiUpdate());

        return controller.update(genreDto);
    }

    @Operation(summary = "Deleting the genre", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the genre"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${genre.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody GenreDto genreDto) {
        log.info("API was called: {}", genreApiString.getGenreApiDelete());

        controller.delete(genreDto);
    }

    @Operation(summary = "Deleting the genre by id", tags = "genre")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the genre by id"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${genre.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long genreId) {
        log.info("API was called: {}", genreApiString.getGenreApiDeleteById());

        controller.deleteById(genreId);
    }
}
