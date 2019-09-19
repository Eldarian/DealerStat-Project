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
public class UserServiceImpl extends AbstractService<User, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
