package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageContentModel {

    @JsonAlias("event_id")
    private String eventId;
    private String body;
    @JsonProperty("msgtype")
    private String msgType = "m.text";
    private String roomId;
}