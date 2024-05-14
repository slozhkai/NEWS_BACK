package com.example.demo.user.service.impl;

import com.example.demo.user.dto.request.AuthDTO;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User auth(AuthDTO request) {
        return userRepository.findUserByLogin(request.getLogin());
    }
}
