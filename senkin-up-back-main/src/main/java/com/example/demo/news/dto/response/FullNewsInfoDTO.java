package com.example.demo.news.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class FullNewsInfoDTO {
    private Integer id;
    private String title;
    private String picture;
    private String textContent;
    private String creator;
    private Date dateCreated;
}
