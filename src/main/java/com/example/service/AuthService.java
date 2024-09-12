package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(User user)
    {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null)
        {
            boolean matches = passwordEncoder.matches(user.getPassword(), existingUser.getPassword());
            logger.info("Password matches: {}", matches);
            if (matches)
            {
                return "Login successful";
            }
        }
        return "Invalid credentials";
    }
}