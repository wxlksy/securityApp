package com.example.repository;

import com.example.model.PasswordEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordEntryRepository extends JpaRepository<PasswordEntry, Long>
{

}