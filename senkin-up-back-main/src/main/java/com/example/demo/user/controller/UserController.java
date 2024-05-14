package com.example.demo.user.controller;

import com.example.demo.user.dto.request.AuthDTO;
import com.example.demo.user.dto.request.CreateUserDTO;
import com.example.demo.user.service.impl.AuthServiceImpl;
import com.example.demo.user.service.impl.UserServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;
    private final AuthServiceImpl authService;

    public UserController(UserServiceImpl userService, AuthServiceImpl authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("")
    public ResponseEntity<?> allUsers () {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById (@PathVariable Integer id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody AuthDTO request) {
        try {
            var user = authService.auth(request);
            if (user != null){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserDTO request) {
        try {
            var user = userService.createUser(request);
            if (user != null){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
