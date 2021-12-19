package com.publicis.sapient.parking.controller;

import com.publicis.sapient.parking.model.User;
import com.publicis.sapient.parking.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * aditya created on 19/12/21
 */
@Controller
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user, String role) {
        return userService.createUser(user, role);
    }
}
