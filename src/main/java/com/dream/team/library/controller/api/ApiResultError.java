package com.dream.team.library.controller.api;

import java.io.Serializable;

public class ApiResultError implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String code;
    private final String message;

    public ApiResultError() {
        this.code = null;
        this.message = null;
    }

    public ApiResultError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResultError(int code, String message) {
        this.code = String.valueOf(code);
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiResultError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
