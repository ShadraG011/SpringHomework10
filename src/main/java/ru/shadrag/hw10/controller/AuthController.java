package ru.shadrag.hw10.controller;

import org.springframework.web.bind.annotation.*;
import ru.shadrag.hw10.model.User;

@RestController
public interface AuthController {
    @PostMapping(value = "/registration")
    User registerUser(@RequestBody User user);

    @PostMapping(value = "/login")
    User loginUser(@RequestBody User user);

    @GetMapping(value = "/logout/{id}")
    User logoutUser(@PathVariable Long userId);
}


