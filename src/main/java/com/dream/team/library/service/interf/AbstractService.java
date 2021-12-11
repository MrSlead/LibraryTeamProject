package com.dream.team.library.service.interf;

import java.util.List;
import java.util.Optional;

public interface AbstractService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T t);
    Optional<T> update(T t);
    void delete(T t);
    void deleteById(ID id);
}
