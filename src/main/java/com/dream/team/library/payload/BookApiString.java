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

    @Value("${book.api.getAllByName}")
    private String bookApiGetAllByName;

    @Value("${book.api.getAllByLanguage}")
    private String bookApiGetAllByLanguage;

    @Value("${book.api.getAllByNumberOfPages}")
    private String bookApiGetAllByNumberOfPages;

    @Value("${book.api.getAllByNumberOfPagesBetween}")
    private String bookApiGetAllByNumberOfPagesBetween;

    @Value("${book.api.getAllByDateOfPublication}")
    private String bookApiGetAllByDateOfPublication;

    @Value("${book.api.getAllByDateOfPublicationBetween}")
    private String bookApiGetAllByDateOfPublicationBetween;

    @Value("${book.api.save}")
    private String bookApiSave;

    @Value("${book.api.update}")
    private String bookApiUpdate;

    @Value("${book.api.delete}")
    private String bookApiDelete;

    @Value("${book.api.deleteById}")
    private String bookApiDeleteById;


    public String getBookApiBegin() {
        return bookApiBegin;
    }

    public String getBookApiGetById() {
        return getBookApiBegin() + bookApiGetById;
    }

    public String getBookApiGetAll() {
        return getBookApiBegin() + bookApiGetAll;
    }

    public String getBookApiGetAllByName() {
        return getBookApiBegin() + bookApiGetAllByName;
    }

    public String getBookApiGetAllByLanguage() {
        return getBookApiBegin() + bookApiGetAllByLanguage;
    }

    public String getBookApiGetAllByNumberOfPages() {
        return getBookApiBegin() + bookApiGetAllByNumberOfPages;
    }

    public String getBookApiGetAllByNumberOfPagesBetween() {
        return getBookApiBegin() + bookApiGetAllByNumberOfPagesBetween;
    }

    public String getBookApiGetAllByDateOfPublication() {
        return getBookApiBegin() + bookApiGetAllByDateOfPublication;
    }

    public String getBookApiGetAllByDateOfPublicationBetween() {
        return getBookApiBegin() + bookApiGetAllByDateOfPublicationBetween;
    }

    public String getBookApiSave() {
        return getBookApiBegin() + bookApiSave;
    }

    public String getBookApiUpdate() {
        return getBookApiBegin() + bookApiUpdate;
    }

    public String getBookApiDelete() {
        return getBookApiBegin() + bookApiDelete;
    }

    public String getBookApiDeleteById() {
        return getBookApiBegin() + bookApiDeleteById;
    }
}
