package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JoinedRoomsModel {

    @JsonProperty("joined_rooms")
    private List<String> joinedRooms = new ArrayList<>();
}