package com.dream.team.library.controller;

import com.dream.team.library.controller.api.ApiResult;
import com.dream.team.library.controller.api.ApiResultError;
import com.dream.team.library.service.interf.AbstractBookDataService;
import com.dream.team.library.service.interf.AbstractService;
import org.springframework.http.HttpStatus;
import java.util.List;

public class AbstractBookDataController<T> extends AbstractController<T> {
    public AbstractBookDataController(AbstractService<T, Long> service) {
        super(service);
    }

    public ApiResult<List<T>> getAllByName(String name) {
        List<T> t = ((AbstractBookDataService<T, Long>) getService()).findAllByName(name);

        if (t.isEmpty()) {
            return ApiResult.error(new ApiResultError(HttpStatus.BAD_REQUEST.value(), "The passed object is null, or is empty"));
        }

        return ApiResult.success(t);
    }
}
