package ru.shadrag.hw10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shadrag.hw10.model.User;
import ru.shadrag.hw10.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController{

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/registration")
    public User registerUser(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping(value = "/login")
    public User loginUser(@RequestBody User user) {
        return authService.loginUser(user.getUsername(), user.getPassword());
    }

    @Override
    public User logoutUser(Long userId) {
        return authService.logoutUser(userId);
    }


}
