package com.example.demo.user.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class PreviewUserDTO {
    private String name;
    private String surname;
    private Date dateRegistered;
}
