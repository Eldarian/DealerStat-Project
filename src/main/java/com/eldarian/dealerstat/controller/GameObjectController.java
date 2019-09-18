package com.eldarian.dealerstat.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GameObjectController {
    @PostMapping("/object")
    public void postObject() {

    }

    @PutMapping("/object")
    public void updateObject() {}

    @GetMapping("/object")
    public void getObject() {}

    @GetMapping("/my")
    public void getUsersObjects() {}

    @DeleteMapping("/object/{id}")
    public void deleteObject() {}
}
