package com.eldarian.dealerstat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @GetMapping("/games")
    public void getGameList() {}

    @PostMapping ("games")
    public void postGame() {

    }

    @PutMapping("/games/{id}")
    public void updateGame() {}

}
