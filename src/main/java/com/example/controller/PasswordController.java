package com.example.controller;

import com.example.model.PasswordEntry;
import com.example.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passwords")

public class PasswordController
{
    @Autowired
    private PasswordService passwordService;

    @PostMapping
    public PasswordEntry createPasswordEntry (@RequestBody PasswordEntry passwordEntry)
    {
        return passwordService.save(passwordEntry);
    }

    @GetMapping
    public List<PasswordEntry> getAllPasswordEntries()
    {
        return passwordService.findAll();
    }

    @GetMapping("/{id}")
    public PasswordEntry getPasswordEntry(@PathVariable Long id)
    {
        return passwordService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePasswordEntry (@PathVariable Long id)
    {
        passwordService.delete(id);
    }
}