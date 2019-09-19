package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.GameObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameObjectRepository extends CommonRepository<GameObject> {
    List<GameObject> findAllByAuthor_Id(Long id);
    List<GameObject> findAllByGame_Id(Long Id);
}
