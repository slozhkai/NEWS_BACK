package com.example.demo.news.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "picture ", columnDefinition = "LONGTEXT" )
    private String picture;

    @Column(name = "text_content ", columnDefinition = "LONGTEXT" )
    private String textContent;

    @Column(name = "date_created")
    private Date dateCreated = new Date();
}
