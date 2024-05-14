package com.example.demo.announcement.service;

import com.example.demo.announcement.dto.request.CreateAnnouncementDTO;
import com.example.demo.announcement.model.Announcement;
import com.example.demo.news.model.News;

import java.util.List;

public interface AnnouncementService {
    Announcement createAnnouncement(CreateAnnouncementDTO request);

    Announcement updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(Integer announcementID);
    Announcement getAnnouncementById(Integer announcementId);
    List<Announcement> getAllAnnouncements();
}
