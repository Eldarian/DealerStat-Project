package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.AbstractEntity;
import com.eldarian.dealerstat.model.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }
    
    public List<E> findAll() {
        return repository.findAll();
    }
    
    public void save(E entity) {
        repository.save(entity);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public HttpStatus update(E entity, Long id) {
        Optional<E> entityOptional = repository.findById(id);
        if (!entityOptional.isPresent()) {
            return HttpStatus.NOT_FOUND;
        }
        entity.setId(id);
        repository.save(entity);
        return HttpStatus.OK;
    }
}
