package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.GameObject;
import com.eldarian.dealerstat.model.service.GameObjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/objects")
public class GameObjectController extends AbstractController<GameObject, GameObjectService> {

    public GameObjectController(GameObjectService service) {
        super(service);
    }

    @GetMapping("/my")
    public void getUsersObjects() {};
}
