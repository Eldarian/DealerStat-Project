package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.AbstractEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/default")
public interface CommonController<E extends AbstractEntity> {
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<E> get(@PathVariable Long id);
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<E>> getAll();

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<E> post(@RequestBody E user);

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<E> put(@RequestBody E user, @PathVariable Long id);

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<E> delete(@PathVariable Long id);
}
