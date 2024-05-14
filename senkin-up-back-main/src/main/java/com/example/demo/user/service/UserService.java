package com.example.demo.user.service;

import com.example.demo.user.dto.request.CreateUserDTO;
import com.example.demo.user.model.User;

import java.util.List;

public interface UserService {
    User createUser(CreateUserDTO request);

    User updateUser(User user);

    void deleteUser(Integer userId);
    User getUserById(Integer userId);
    List<User> getAllUsers();
}


