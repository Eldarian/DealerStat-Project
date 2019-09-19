package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.AbstractEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {
    Optional<E> findById(Long id);
    List<E> findAll();
    void save(E entity);
    void deleteById(Long id);
    HttpStatus update(E entity, Long id);
}
