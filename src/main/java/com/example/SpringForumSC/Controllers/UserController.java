package com.example.SpringForumSC.Controllers;

import com.example.SpringForumSC.Entities.User;
import com.example.SpringForumSC.Repositories.UserRepository;
import com.example.SpringForumSC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> findAll(){ return userService.findAll(); }



}
