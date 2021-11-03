package com.dream.team.library.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthApiString {
    @Value("${auth.api.begin}")
    private String authApiBegin;

    @Value("${auth.api.login}")
    private String authApiLogin;

    @Value("${auth.api.registration}")
    private String authApiRegistration;

    public String getAuthApiBegin() {
        return authApiBegin;
    }

    public String getAuthApiLogin() {
        return authApiBegin + authApiLogin;
    }

    public String getAuthApiRegistration() {
        return authApiBegin + authApiRegistration;
    }
}
