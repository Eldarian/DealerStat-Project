package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        log.info("IN UserServiceImpl findById {}", id);
        return userRepository.findById(id);
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

    public HttpStatus updateUser(User user, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return HttpStatus.NOT_FOUND;
        }
        user.setUserId(id);
        userRepository.save(user);
        return HttpStatus.OK;
    }
}
