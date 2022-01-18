package com.test.chat.matrix.dto;

import lombok.Data;

@Data
public class MessageContentDto {

    private String eventId;
    private String body;
    private String roomId;
}