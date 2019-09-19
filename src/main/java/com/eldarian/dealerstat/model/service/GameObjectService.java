package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.GameObject;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface GameObjectService {
    Optional<GameObject> findGameObjectById(Long id);
    List<GameObject> findAllGameObjects();
    void saveGameObject(GameObject gameObject);
    void deleteGameObjectById(Long id);
    HttpStatus updateGameObject(GameObject gameObject, Long id);
}
