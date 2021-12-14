package com.dream.team.library.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthorApiString {

    @Value("${author.api.begin}")
    private String authorApiBegin;

    @Value("${author.api.getById}")
    private String authorApiGetById;

    @Value("${author.api.getAll}")
    private String authorApiGetAll;

    @Value("${author.api.getAllByName}")
    private String authorApiGetAllByName;

    @Value("${author.api.getAllBySurname}")
    private String authorApiGetAllBySurname;

    @Value("${author.api.getAllByPatronymic}")
    private String authorApiGetAllByPatronymic;

    @Value("${author.api.save}")
    private String authorApiSave;

    @Value("${author.api.update}")
    private String authorApiUpdate;

    @Value("${author.api.delete}")
    private String authorApiDelete;

    @Value("${author.api.deleteById}")
    private String authorApiDeleteById;


    public String getAuthorApiBegin() {
        return authorApiBegin;
    }

    public String getAuthorApiGetById() {
        return getAuthorApiBegin() + authorApiGetById;
    }

    public String getAuthorApiGetAll() {
        return getAuthorApiBegin() + authorApiGetAll;
    }

    public String getAuthorApiGetAllByName() {
        return getAuthorApiBegin() + authorApiGetAllByName;
    }

    public String getAuthorApiGetAllBySurname() {
        return getAuthorApiBegin() + authorApiGetAllBySurname;
    }

    public String getAuthorApiGetAllByPatronymic() {
        return getAuthorApiBegin() + authorApiGetAllByPatronymic;
    }

    public String getAuthorApiSave() {
        return getAuthorApiBegin() + authorApiSave;
    }

    public String getAuthorApiUpdate() {
        return getAuthorApiBegin() + authorApiUpdate;
    }

    public String getAuthorApiDelete() {
        return getAuthorApiBegin() + authorApiDelete;
    }

    public String getAuthorApiDeleteById() {
        return getAuthorApiBegin() + authorApiDeleteById;
    }
}
