package com.dream.team.library.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LanguageApiString {

    @Value("${language.api.begin}")
    private String languageApiBegin;

    @Value("${language.api.getById}")
    private String languageApiGetById;

    @Value("${language.api.getAll}")
    private String languageApiGetAll;

    @Value("${language.api.getAllByName}")
    private String languageApiGetAllByName;

    @Value("${language.api.save}")
    private String languageApiSave;

    @Value("${language.api.update}")
    private String languageApiUpdate;

    @Value("${language.api.delete}")
    private String languageApiDelete;

    @Value("${language.api.deleteById}")
    private String languageApiDeleteById;


    public String getLanguageApiBegin() {
        return languageApiBegin;
    }

    public String getLanguageApiGetById() {
        return getLanguageApiBegin() + languageApiGetById;
    }

    public String getLanguageApiGetAll() {
        return getLanguageApiBegin() + languageApiGetAll;
    }

    public String getLanguageApiGetAllByName() {
        return getLanguageApiBegin() + languageApiGetAllByName;
    }

    public String getLanguageApiSave() {
        return getLanguageApiBegin() + languageApiSave;
    }

    public String getLanguageApiUpdate() {
        return getLanguageApiBegin() + languageApiUpdate;
    }

    public String getLanguageApiDelete() {
        return getLanguageApiBegin() + languageApiDelete;
    }

    public String getLanguageApiDeleteById() {
        return getLanguageApiBegin() + languageApiDeleteById;
    }
}
