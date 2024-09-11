package com.example.service;

import com.example.model.PasswordEntry;
import com.example.repository.PasswordEntryRepository;
import com.example.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    @Autowired
    private PasswordEntryRepository passwordEntryRepository;

    private static final String ENCRYPTION_KEY = "your-encryption-key"; // Замените на сгенерированный ключ

    public PasswordEntry save(PasswordEntry passwordEntry) {
        try {
            passwordEntry.setPassword(EncryptionUtil.encrypt(passwordEntry.getPassword(), ENCRYPTION_KEY));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwordEntryRepository.save(passwordEntry);
    }

    public List<PasswordEntry> findAll() {
        List<PasswordEntry> passwordEntries = passwordEntryRepository.findAll();
        for (PasswordEntry passwordEntry : passwordEntries) {
            try {
                passwordEntry.setPassword(EncryptionUtil.decrypt(passwordEntry.getPassword(), ENCRYPTION_KEY));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return passwordEntries;
    }

    public PasswordEntry findById(Long id) {
        PasswordEntry passwordEntry = passwordEntryRepository.findById(id).orElse(null);
        if (passwordEntry != null) {
            try {
                passwordEntry.setPassword(EncryptionUtil.decrypt(passwordEntry.getPassword(), ENCRYPTION_KEY));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return passwordEntry;
    }

    public void delete(Long id) {
        passwordEntryRepository.deleteById(id);
    }
}
