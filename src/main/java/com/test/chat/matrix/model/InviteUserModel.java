package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InviteUserModel {

    @JsonProperty("user_id")
    private String userId;
}