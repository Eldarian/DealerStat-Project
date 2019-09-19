package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameObjectRepository extends JpaRepository<GameObject, Long> {
    List<GameObject> findGameObjectsByAuthors(Long userId);
    List<GameObject> findGameObjectsByGameGameId(Long gameId);
}
