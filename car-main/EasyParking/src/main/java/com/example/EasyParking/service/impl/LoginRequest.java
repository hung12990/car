package com.example.EasyParking.service.impl;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}