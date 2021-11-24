package com.dream.team.library.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookApiString {

    @Value("${book.api.begin}")
    private String bookApiBegin;

    @Value("${book.api.getById}")
    private String bookApiGetById;

    @Value("${book.api.getAll}")
    private String bookApiGetAll;

    @Value("${book.api.save}")
    private String bookApiSave;

    @Value("${book.api.delete}")
    private String bookApiDelete;

    @Value("${book.api.deleteById}")
    private String bookApiDeleteById;


    public String getBookApiBegin() {
        return bookApiBegin;
    }

    public String getBookApiGetById() {
        return bookApiBegin + bookApiGetById;
    }

    public String getBookApiGetAll() {
        return bookApiBegin + bookApiGetAll;
    }

    public String getBookApiSave() {
        return bookApiBegin + bookApiSave;
    }

    public String getBookApiDelete() {
        return bookApiBegin + bookApiDelete;
    }

    public String getBookApiDeleteById() {
        return bookApiBegin + bookApiDeleteById;
    }
}
