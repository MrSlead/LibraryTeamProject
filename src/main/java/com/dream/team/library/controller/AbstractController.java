package com.dream.team.library.controller;

import com.dream.team.library.service.interf.AbstractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class AbstractController<T> {
    private final AbstractService<T, Long> service;

    public AbstractController(AbstractService<T, Long> service) {
        this.service = service;
    }

    public ResponseEntity<Optional<T>> getObjectById(Long objectId) {
        if (objectId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<T> t = service.findById(objectId);

        if(t.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    public ResponseEntity<List<T>> getAll() {
        List<T> t = service.findAll();

        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    public ResponseEntity<T> save(T t) {
        if (service.save(t).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public void deleteById(Long objectId) {
        if (objectId != null ) {
            service.deleteById(objectId);
        }
    }
}
