package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.GameObject;
import com.eldarian.dealerstat.model.repository.GameObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Slf4j
public class GameObjectServiceImpl implements GameObjectService{
    @Autowired
    private GameObjectRepository gameObjectRepository;
    
    @Override
    public Optional<GameObject> findGameObjectById(Long id) {
        log.info("IN GameObjectServiceImpl findGameObjectById {}", id);
        return gameObjectRepository.findById(id);
    }

    @Override
    public List<GameObject> findAllGameObjects() {
        log.info("IN GameObjectServiceImpl findAllGameObjects");
        return gameObjectRepository.findAll();
    }

    @Override
    public void saveGameObject(GameObject gameObject) {
        log.info("IN GameObjectServiceImpl saveGameObject {}", gameObject);
        gameObjectRepository.save(gameObject);
    }

    @Override
    public void deleteGameObjectById(Long id) {
        log.info("IN GameObjectServiceImpl deleteGameObjectById {}", id);
        gameObjectRepository.deleteById(id);
    }

    @Override
    public HttpStatus updateGameObject(GameObject gameObject, Long id) {
        log.info("IN GameObjectServiceImpl updateGameObject {}", id);
        Optional<GameObject> gameObjectOptional = gameObjectRepository.findById(id);
        if (!gameObjectOptional.isPresent()) {
            return HttpStatus.NOT_FOUND;
        }
        gameObject.setGameObjectId(id);
        gameObjectRepository.save(gameObject);
        return HttpStatus.OK;
    }
}
