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

    @Value("${author.api.save}")
    private String authorApiSave;

    @Value("${author.api.delete}")
    private String authorApiDelete;

    @Value("${author.api.deleteById}")
    private String authorApiDeleteById;


    public String getAuthorApiBegin() {
        return authorApiBegin;
    }

    public String getAuthorApiGetById() {
        return authorApiBegin + authorApiGetById;
    }

    public String getAuthorApiGetAll() {
        return authorApiBegin + authorApiGetAll;
    }

    public String getAuthorApiSave() {
        return authorApiBegin + authorApiSave;
    }

    public String getAuthorApiDelete() {
        return authorApiBegin + authorApiDelete;
    }

    public String getAuthorApiDeleteById() {
        return authorApiBegin + authorApiDeleteById;
    }
}
