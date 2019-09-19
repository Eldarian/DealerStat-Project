package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.Game;
import com.eldarian.dealerstat.model.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController extends AbstractController<Game, GameService> implements CommonController<Game> {

    public GameController(GameService service) {
        super(service);
    }

}
