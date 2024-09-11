package com.example.controller;

import com.example.model.User;
import com.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user)
    {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user)
    {
        return authService.login(user);
    }
}