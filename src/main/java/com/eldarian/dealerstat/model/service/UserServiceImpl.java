package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    public User findById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return repo.findAll();
    }

    public void saveUser(User user) {
        repo.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        repo.save(user);
        User entity = repo.findById(user.getId()).get();
        if(entity!=null) {
            entity.setName(user.getName());
            entity.setCreatedAt(user.getCreatedAt());
        }
    }
}
