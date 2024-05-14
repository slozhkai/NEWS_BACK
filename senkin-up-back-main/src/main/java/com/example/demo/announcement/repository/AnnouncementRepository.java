package com.example.demo.announcement.repository;

import com.example.demo.announcement.model.Announcement;
import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    void deleteAllByUser (User user);
}
