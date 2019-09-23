package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.GameObject;
import com.eldarian.dealerstat.model.repository.GameObjectRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GameObjectServiceImpl extends AbstractService<GameObject, GameObjectRepository> implements GameObjectService{
    public GameObjectServiceImpl(GameObjectRepository repository) {
        super(repository);
    }
}
