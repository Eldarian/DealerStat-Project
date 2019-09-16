package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.User;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


public class UserRepositoryImpl extends SimpleJpaRepository<User, Long> /*implements UserRepository*/ {
    private EntityManager entityManager;

    public UserRepositoryImpl(JpaEntityInformation<User, Long> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }
}
