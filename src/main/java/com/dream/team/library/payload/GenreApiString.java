package com.dream.team.library.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GenreApiString {

    @Value("${genre.api.begin}")
    private String genreApiBegin;

    @Value("${genre.api.getById}")
    private String genreApiGetById;

    @Value("${genre.api.getAll}")
    private String genreApiGetAll;

    @Value("${genre.api.getAllByName}")
    private String genreApiGetAllByName;

    @Value("${genre.api.save}")
    private String genreApiSave;

    @Value("${genre.api.update}")
    private String genreApiUpdate;

    @Value("${genre.api.delete}")
    private String genreApiDelete;

    @Value("${genre.api.deleteById}")
    private String genreApiDeleteById;


    public String getGenreApiBegin() {
        return genreApiBegin;
    }

    public String getGenreApiGetById() {
        return getGenreApiBegin() + genreApiGetById;
    }

    public String getGenreApiGetAll() {
        return getGenreApiBegin() + genreApiGetAll;
    }

    public String getGenreApiGetAllByName() {
        return getGenreApiBegin() + genreApiGetAllByName;
    }

    public String getGenreApiSave() {
        return getGenreApiBegin() + genreApiSave;
    }

    public String getGenreApiUpdate() {
        return getGenreApiBegin() + genreApiUpdate;
    }

    public String getGenreApiDelete() {
        return getGenreApiBegin() + genreApiDelete;
    }

    public String getGenreApiDeleteById() {
        return getGenreApiBegin() + genreApiDeleteById;
    }
}
