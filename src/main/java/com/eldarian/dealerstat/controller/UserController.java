package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.User;
import com.eldarian.dealerstat.model.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traders")
public class UserController extends AbstractController<User, UserService>  {
    public UserController(UserService service) {
        super(service);
    }
}
