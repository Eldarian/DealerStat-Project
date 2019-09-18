package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameObjectRepository extends JpaRepository<GameObject, Long> {
//    List<GameObject> findGameObjectsByUser(Long userId);
//    List<GameObject> findGameObjectsByGame(Long gameId);
}
