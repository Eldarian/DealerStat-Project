package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.Game;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CommonRepository<Game> {
    Game findByName(String name);
}
