package com.dream.team.library.controller;

import com.dream.team.library.service.interf.AbstractBookDataService;
import com.dream.team.library.service.interf.AbstractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class AbstractBookDataController<T> extends AbstractController<T> {
    public AbstractBookDataController(AbstractService<T, Long> service) {
        super(service);
    }

    public ResponseEntity<List<T>> getAllByName(String name) {
        List<T> t = ((AbstractBookDataService<T, Long>) getService()).findAllByName(name);

        if (t.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
