package com.dream.team.library.controller;

import com.dream.team.library.controller.api.ApiResult;
import com.dream.team.library.controller.api.ApiResultError;
import com.dream.team.library.service.interf.AbstractService;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

public class AbstractController<T> {
    private final AbstractService<T, Long> service;

    public AbstractController(AbstractService<T, Long> service) {
        this.service = service;
    }

    public AbstractService<T, Long> getService() {
        return service;
    }

    public ApiResult<Optional<T>> getObjectById(Long objectId) {
        if (objectId == null) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed parameter is null"));
        }

        Optional<T> t = service.findById(objectId);

        if (t.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.NOT_FOUND.value(), "The object by id not found"));
        }

        return ApiResult.success(t);
    }

    public ApiResult<List<T>> getAll() {
        List<T> t = service.findAll();

        return ApiResult.success(t);
    }

    public ApiResult<T> save(T t) {
        Optional<T> obj = service.save(t);

        if (obj.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or it has id"));
        }

        return ApiResult.success(obj.get());
    }

    public ApiResult<T> update(T t) {
        Optional<T> obj = service.update(t);

        if (obj.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(),
                    "The passed object is null, or it has no id, or it not contained in the database"));
        }

        return ApiResult.success(t);
    }

    public void delete(T t) {
        if (t != null ) {
            service.delete(t);
        }
    }

    public void deleteById(Long objectId) {
        if (objectId != null ) {
            service.deleteById(objectId);
        }
    }
}
