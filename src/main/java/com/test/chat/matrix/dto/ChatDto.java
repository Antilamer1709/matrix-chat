package com.test.chat.matrix.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatDto {

    private List<MessageDto> messages;
    private String end;
}