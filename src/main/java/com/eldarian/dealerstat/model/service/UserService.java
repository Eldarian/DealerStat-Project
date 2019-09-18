package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.User;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    List<User> findAllUsers();
    void saveUser(User user);
    void deleteUserById(Long id);
    HttpStatus updateUser(User user, Long id);
}
