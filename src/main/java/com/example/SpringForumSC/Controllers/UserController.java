package com.example.SpringForumSC.Controllers;

import com.example.SpringForumSC.Repositories.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}