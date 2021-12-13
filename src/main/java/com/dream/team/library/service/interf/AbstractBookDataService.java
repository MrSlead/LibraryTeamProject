package com.dream.team.library.service.interf;

import java.util.List;

public interface AbstractBookDataService<T, ID> extends AbstractService<T, ID> {
    List<T> findAllByName(String name);
}
