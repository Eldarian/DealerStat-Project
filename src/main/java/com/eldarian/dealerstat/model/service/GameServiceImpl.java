package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.Game;
import com.eldarian.dealerstat.model.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GameServiceImpl extends AbstractService<Game, GameRepository> implements GameService {
    public GameServiceImpl(GameRepository repository) {
        super(repository);
    }
}
