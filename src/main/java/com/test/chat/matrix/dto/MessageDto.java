package com.test.chat.matrix.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    private String type;
    private String sender;
    private MessageContentDto content;
    private LocalDateTime dateTime;
}