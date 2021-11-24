package com.dream.team.library.service.interf;

import java.util.List;
import java.util.Optional;

// TODO: добавить метод update, провести его до контроллеров, пока нет возможности в обновлении сущностей.
public interface AbstractService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    Optional<T> save(T t);
    void delete(T t);
    void deleteById(ID id);
}
