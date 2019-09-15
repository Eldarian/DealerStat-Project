package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.GameObject;

import java.util.List;

public interface GameObjectRepository {
    GameObject findGameObjectById(int gameObjectId);
    void saveGameObject(GameObject gameObject);
    void deleteGameObject(GameObject gameObject);
    List<GameObject> findGameObjectsByUser(int userId);
    List<GameObject> findGameObjectsByGame(int gameId);
}
