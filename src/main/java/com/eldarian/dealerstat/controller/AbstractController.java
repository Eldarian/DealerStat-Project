package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.AbstractEntity;
import com.eldarian.dealerstat.model.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> implements CommonController<E>{
    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }
    public S getService() {
        return this.service;
    }


    public ResponseEntity<E> get(@PathVariable Long id) {
        if (!this.service.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        E entity = this.service.findById(id).get();
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    public ResponseEntity<List<E>> getAll() {
        List<E> entityList = this.service.findAll();
        return generateListResponse(entityList);
    }

    public ResponseEntity<E> post(@RequestBody E entity) {
        HttpHeaders headers = new HttpHeaders();
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.service.save(entity);
        return new ResponseEntity<>(entity, headers, HttpStatus.CREATED);
    }

    public ResponseEntity<E> put(@RequestBody E entity, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(entity, id));
    }

    public ResponseEntity<E> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected ResponseEntity<List<E>> generateListResponse(List<E> entityList) {
        if (entityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }
}
