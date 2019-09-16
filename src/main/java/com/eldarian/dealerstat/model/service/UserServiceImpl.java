package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        log.info("IN UserServiceImpl findById {}", id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        log.info("IN UserServiceImpl findAllUsers");
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        log.info("IN UserServiceImpl saveUser {}", user);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        log.info("IN UserServiceImpl deleteUserById {}", id);
        userRepository.deleteById(id);
    }

    /*public void updateUser(User user) {
        userRepository.save(user);
        User entity = userRepository.findById(user.getId()).get();
        if(entity!=null) {
            entity.setName(user.getName());
            entity.setCreatedAt(user.getCreatedAt());
        }
    }*/
}
