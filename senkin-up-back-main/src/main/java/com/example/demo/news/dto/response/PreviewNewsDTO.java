package com.example.demo.news.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class PreviewNewsDTO {
    private Integer id;
    private String title;
    private String picture;
    private Date dateCreated;
}
