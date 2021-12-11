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
        return languageApiBegin + languageApiGetById;
    }

    public String getLanguageApiGetAll() {
        return languageApiBegin + languageApiGetAll;
    }

    public String getLanguageApiSave() {
        return languageApiBegin + languageApiSave;
    }

    public String getLanguageApiUpdate() {
        return languageApiBegin + languageApiUpdate;
    }

    public String getLanguageApiDelete() {
        return languageApiBegin + languageApiDelete;
    }

    public String getLanguageApiDeleteById() {
        return languageApiBegin + languageApiDeleteById;
    }
}
