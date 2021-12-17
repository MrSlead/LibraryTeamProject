package com.dream.team.library.controller.api;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ApiResultStatus status;
    private final T result;
    private final List<ApiResultError> errors;

    public ApiResult() {
        this.status = null;
        this.result = null;
        this.errors = null;
    }

    public ApiResult(ApiResultStatus status, T result, List<ApiResultError> errors) {
        this.status = status;
        this.result = result;
        this.errors = errors;
    }

    public static <T> ApiResult<T> success(T result) {
        return new ApiResult<>(ApiResultStatus.SUCCESS, result, Collections.emptyList());
    }

    public static <T> ApiResult<T> errors(List<ApiResultError> errors) {
        return new ApiResult<>(ApiResultStatus.ERROR, null, Collections.unmodifiableList(errors));
    }

    public static <T> ApiResult<T> error(ApiResultError error) {
        return new ApiResult<>(ApiResultStatus.ERROR, null, Collections.singletonList(error));
    }

    public ApiResultStatus getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

    public List<ApiResultError> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "status=" + status +
                ", result=" + result +
                ", errors=" + errors +
                '}';
    }
}
