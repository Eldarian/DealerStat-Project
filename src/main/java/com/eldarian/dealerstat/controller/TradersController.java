package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("traders")
public class TradersController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public String getUser(@PathVariable int id) {
        return userService.findById(id).toString();
    }

    @GetMapping
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "allusers";
    }

    @PostMapping
    public void postUser() {}

    @PutMapping
    public void putUser() {}


}
