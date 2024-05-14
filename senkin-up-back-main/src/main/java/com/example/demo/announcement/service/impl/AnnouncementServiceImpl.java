package com.example.demo.announcement.service.impl;

import com.example.demo.announcement.dto.request.CreateAnnouncementDTO;
import com.example.demo.announcement.model.Announcement;
import com.example.demo.announcement.repository.AnnouncementRepository;
import com.example.demo.announcement.service.AnnouncementService;
import com.example.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, UserRepository userRepository) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Announcement createAnnouncement(CreateAnnouncementDTO request) {
        var announcement = new Announcement();
        announcement.setTitle(request.getTitle());
        announcement.setPicture(request.getPicture());
        announcement.setTextContent(request.getTextContent());
        var user = userRepository.findUserById(request.getUserId());
        announcement.setUser(user);
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public void deleteAnnouncement(Integer announcementID) {
        Announcement announcement = announcementRepository.findById(announcementID)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Удаляем самого пользователя
        announcementRepository.deleteById(announcementID);
    }

    @Override
    public Announcement getAnnouncementById(Integer announcementId) {
        return announcementRepository.findById(announcementId).orElse(null);
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }
}
