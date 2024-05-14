package com.example.demo.user.dto.request;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String login;
    private String password;
    private String name;
    private String surname;
}
