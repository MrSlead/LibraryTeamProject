package com.dream.team.library.controller;

import com.dream.team.library.controller.api.ApiResult;
import com.dream.team.library.controller.helper.ExampleObjectHelper;
import com.dream.team.library.dto.LanguageDto;
import com.dream.team.library.payload.LanguageApiString;
import com.dream.team.library.service.interf.LanguageService;
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

@Tag(name = "Language", description = "The Language API")
@Slf4j
@RestController
// Разрешение на получение данных только из указанного источника.
@CrossOrigin(origins = "${cross.origin.path}")
@RequestMapping("${language.api.begin}")
public class LanguageController {
    private AbstractController<LanguageDto> controller;
    private LanguageService languageService;
    private LanguageApiString languageApiString;

    @Qualifier("AbstractBookDataControllerForLanguage")
    @Autowired
    public void setController(AbstractController<LanguageDto> controller) {
        this.controller = controller;
    }

    @Autowired
    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Autowired
    public void setGenreApiString(LanguageApiString languageApiString) {
        this.languageApiString = languageApiString;
    }

    @Operation(summary = "Get language by id", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the language by id"
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
    @GetMapping(value = "${language.api.getById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<Optional<LanguageDto>> getLanguageById(@PathVariable Long languageId) {
        log.info("API was called: {}", languageApiString.getLanguageApiGetById());

        return controller.getObjectById(languageId);
    }

    @Operation(summary = "Gets all languages", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the languages"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @GetMapping(value = "${language.api.getAll}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<List<LanguageDto>> getAll() {
        log.info("API was called: {}", languageApiString.getLanguageApiGetAll());

        return controller.getAll();
    }

    @Operation(summary = "Get language by name", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the language"
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
    public ApiResult<List<LanguageDto>> getAllByName(@PathVariable String name) {
        log.info("API was called: {}", languageApiString.getLanguageApiGetAllByName());

        return ((AbstractBookDataController<LanguageDto>) controller).getAllByName(name);
    }

    @Operation(summary = "Saving the language", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved the language"
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
    @PostMapping(value = "${language.api.save}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<LanguageDto> save(@RequestBody LanguageDto languageDto) {
        log.info("API was called: {}", languageApiString.getLanguageApiSave());

        return controller.save(languageDto);
    }

    @Operation(summary = "Updating the language", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated the language"
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
    @PutMapping(value = "${language.api.update}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<LanguageDto> update(@RequestBody LanguageDto languageDto) {
        log.info("API was called: {}", languageApiString.getLanguageApiUpdate());

        return controller.update(languageDto);
    }

    @Operation(summary = "Deleting the language", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the language"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${language.api.delete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody LanguageDto languageDto) {
        log.info("API was called: {}", languageApiString.getLanguageApiDelete());

        controller.delete(languageDto);
    }

    @Operation(summary = "Deleting the language by id", tags = "language")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted the language by id"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized",
                    content = @Content
            )
    })
    @DeleteMapping(value = "${language.api.deleteById}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long languageId) {
        log.info("API was called: {}", languageApiString.getLanguageApiDeleteById());

        controller.deleteById(languageId);
    }
}
