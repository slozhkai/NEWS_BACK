package com.example.demo.announcement.model;

import com.example.demo.user.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "picture ", columnDefinition = "LONGTEXT" )
    private String picture;

    @Column(name = "text_content ", columnDefinition = "LONGTEXT" )
    private String textContent;

    @Column(name = "date_created")
    private Date dateCreated = new Date();

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
