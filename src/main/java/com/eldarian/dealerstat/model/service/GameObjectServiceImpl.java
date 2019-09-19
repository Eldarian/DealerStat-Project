package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.GameObject;
import com.eldarian.dealerstat.model.repository.GameObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class GameObjectServiceImpl extends AbstractService<GameObject, GameObjectRepository> implements GameObjectService{
    public GameObjectServiceImpl(GameObjectRepository repository) {
        super(repository);
    }
}
