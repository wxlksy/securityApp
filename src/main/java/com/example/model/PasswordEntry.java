package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
public class PasswordEntry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String site;
    private String username;
    private String password;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSite()
    {
        return site;
    }

    public void setSite (String site)
    {
        this.site = site;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername (String site)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword (String site)
    {
        this.password = password;
    }
}