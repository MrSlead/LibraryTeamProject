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
        return genreApiBegin + genreApiGetById;
    }

    public String getGenreApiGetAll() {
        return genreApiBegin + genreApiGetAll;
    }

    public String getGenreApiSave() {
        return genreApiBegin + genreApiSave;
    }

    public String getGenreApiUpdate() {
        return genreApiBegin + genreApiUpdate;
    }

    public String getGenreApiDelete() {
        return genreApiBegin + genreApiDelete;
    }

    public String getGenreApiDeleteById() {
        return genreApiBegin + genreApiDeleteById;
    }
}
