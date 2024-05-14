package com.example.demo.announcement.dto.request;

import lombok.Data;

@Data
public class CreateAnnouncementDTO {
    private String title;
    private String picture;
    private String textContent;
    private Integer userId;
}
