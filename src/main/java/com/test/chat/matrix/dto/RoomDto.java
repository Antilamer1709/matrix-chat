package com.test.chat.matrix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private String id;
    private String name;
    private String topic;

    public RoomDto(String id) {
        this.id = id;
    }
}