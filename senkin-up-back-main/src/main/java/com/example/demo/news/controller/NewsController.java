package com.example.demo.news.controller;

import com.example.demo.news.dto.request.CreateNewsDTO;
import com.example.demo.news.service.Impl.NewsServiceImpl;
import com.example.demo.user.dto.request.CreateUserDTO;
import com.example.demo.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsServiceImpl newsService;

    public NewsController(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @GetMapping("")
    public ResponseEntity<?> allNews(){
        return new ResponseEntity<>(newsService.getAllNews(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById (@PathVariable Integer id){
        return new ResponseEntity<>(newsService.getNewsById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateNewsDTO request) {
        try {
            var createdUser = newsService.createNews(request);
            if (createdUser != null){
                return new ResponseEntity<>(createdUser, HttpStatus.OK);
            }
            return new ResponseEntity<>("User already exist", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Integer id) {
        newsService.deleteNews(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

}
