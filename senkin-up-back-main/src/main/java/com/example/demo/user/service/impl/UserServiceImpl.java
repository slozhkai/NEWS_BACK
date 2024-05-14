package com.example.demo.user.service.impl;

import com.example.demo.announcement.repository.AnnouncementRepository;
import com.example.demo.user.dto.request.CreateUserDTO;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AnnouncementRepository announcementRepository;

    public UserServiceImpl(UserRepository userRepository, AnnouncementRepository announcementRepository) {
        this.userRepository = userRepository;
        this.announcementRepository = announcementRepository;
    }

    @Override
    public User createUser(CreateUserDTO request) {
        if (userRepository.findUserByLogin(request.getLogin()) == null){
            var user = new User();
            user.setLogin(request.getLogin());
            user.setPassword(request.getPassword());
            user.setName(request.getName());
            user.setSurname(request.getSurname());  
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Удаляем самого пользователя
        announcementRepository.deleteAllByUser(user);
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
