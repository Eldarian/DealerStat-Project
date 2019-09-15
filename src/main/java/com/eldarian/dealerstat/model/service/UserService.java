package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.User;

import java.util.List;

public interface UserService {
    User findById(long id);
    List<User> findAllUsers();
    void saveUser(User user);
    void deleteUserById(long id);
    void updateUser(User user);
}
