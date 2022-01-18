package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class RoomModel {

    @JsonAlias("room_id")
    private String id;
    private String name;
    private String topic;
}