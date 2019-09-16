package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("traders")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        if (userService.findById(id) == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        User user = this.userService.findById(id);

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        this.userService.saveUser(user);
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public void putUser() {}


}
