package com.example.demo.user.model;
import com.example.demo.announcement.model.Announcement;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "login", length = 20, unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "date_registered")
    private Date dateRegistered = new Date();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Announcement> announcements;
}
