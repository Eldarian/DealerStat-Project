package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
