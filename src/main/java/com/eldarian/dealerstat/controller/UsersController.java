package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("traders")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public String getUser(@PathVariable int id) {
        return userService.findById(id).toString();
    }

    @GetMapping
    public String listUsers(ModelMap model) {
        if (userService.findAllUsers().size() == 0) return "empty";
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "allusers";
    }

    @PostMapping
    public void postUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping
    public void putUser() {}


}
