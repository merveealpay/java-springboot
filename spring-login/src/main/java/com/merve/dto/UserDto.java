package com.merve.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class UserDto {
    private String firstname;
    private String lastname;
    private String username;
    private boolean enabled;
    private long id;
    private String role;
    private String email;
    private String password;
    private Collection<String> roles;
    private Collection<String> users;

}
