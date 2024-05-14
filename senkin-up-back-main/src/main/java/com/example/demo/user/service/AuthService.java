package com.example.demo.user.service;

import com.example.demo.user.dto.request.AuthDTO;
import com.example.demo.user.model.User;

public interface AuthService {
    User auth (AuthDTO request);
}
