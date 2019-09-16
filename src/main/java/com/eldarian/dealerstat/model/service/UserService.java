package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAllUsers();
    void saveUser(User user);
    void deleteUserById(Long id);
}
