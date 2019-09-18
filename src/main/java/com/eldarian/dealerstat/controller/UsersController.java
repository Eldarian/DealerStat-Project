package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/traders")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        if (!this.userService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = this.userService.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = this.userService.findAllUsers();
        if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> postUser(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        this.userService.saveUser(user);
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> putUser(@RequestBody User user, @PathVariable Long id) {
        return new ResponseEntity<>(userService.updateUser(user, id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
