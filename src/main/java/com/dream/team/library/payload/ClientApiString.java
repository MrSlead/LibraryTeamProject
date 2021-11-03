package com.dream.team.library.payload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientApiString {

    @Value("${client.api.begin}")
    private String clientApiBegin;

    @Value("${client.api.getById}")
    private String clientApiGetById;

    @Value("${client.api.getByLogin}")
    private String clientApiGetByLogin;

    @Value("${client.api.getAll}")
    private String clientApiGetAll;

    @Value("${client.api.getPremium}")
    private String clientApiGetPremium;

    @Value(("${client.api.getOrdinary}"))
    private String clientApiGetOrdinary;


    public String getClientApiBegin() {
        return clientApiBegin;
    }

    public String getClientApiGetById() {
        return clientApiBegin + clientApiGetById;
    }

    public String getClientApiGetByLogin() {
        return clientApiBegin + clientApiGetByLogin;
    }

    public String getClientApiGetAll() {
        return clientApiBegin + clientApiGetAll;
    }

    public String getClientApiGetPremium() {
        return clientApiBegin + clientApiGetPremium;
    }

    public String getClientApiGetOrdinary() {
        return clientApiBegin + clientApiGetOrdinary;
    }
}
