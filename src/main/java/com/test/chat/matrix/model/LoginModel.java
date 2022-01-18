package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class LoginModel {

    private String password;

    private String type = "m.login.password";
    private IdentifierModel identifier;
    @JsonAlias("user_id")
    private String userId;
    @JsonAlias("access_token")
    private String accessToken;

    @Data
    public static class IdentifierModel {

        private String type = "m.id.user";
        private String user;
    }
}