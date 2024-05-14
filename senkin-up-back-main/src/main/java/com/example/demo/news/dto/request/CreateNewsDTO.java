package com.example.demo.news.dto.request;

import lombok.Data;

@Data
public class CreateNewsDTO {
    private String title;
    private String picture;
    private String textContent;
}
