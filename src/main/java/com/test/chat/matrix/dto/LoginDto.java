package com.test.chat.matrix.dto;

import lombok.Data;

@Data
public class LoginDto {

    private String userId;
    private String username;
    private String password;
    private String accessToken;
}