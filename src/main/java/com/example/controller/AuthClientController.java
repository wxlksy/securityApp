package com.example.controller;

import com.example.service.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class AuthClientController {

    @Autowired
    private AuthServiceClient authServiceClient;

    @GetMapping("/register")
    public String registerUser() {
        return authServiceClient.registerUser("testuser", "password");
    }

    @GetMapping("/login")
    public String loginUser() {
        return authServiceClient.loginUser("testuser", "password");
    }
}

