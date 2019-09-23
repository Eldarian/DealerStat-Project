package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.Comment;
import com.eldarian.dealerstat.model.entities.GameObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameObjectRepository extends CommonRepository<GameObject> {
    List<GameObject> findAllByOwner_Id(Long id);
    List<GameObject> findAllByGame_Id(Long Id);
    List<GameObject> findAllByGame_Name(String name);
}
