package com.example.demo.announcement.controller;

import com.example.demo.announcement.dto.request.CreateAnnouncementDTO;
import com.example.demo.announcement.service.impl.AnnouncementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementServiceImpl announcementService;

    @Autowired
    public AnnouncementController(AnnouncementServiceImpl announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("")
    public ResponseEntity<?> allAnnouncements(){
        return new ResponseEntity<>(announcementService.getAllAnnouncements(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById (@PathVariable Integer id){
        return new ResponseEntity<>(announcementService.getAnnouncementById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateAnnouncementDTO request) {
        try {
            var createdUser = announcementService.createAnnouncement(request);
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
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
