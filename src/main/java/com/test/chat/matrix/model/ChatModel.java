package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatModel {

    @JsonProperty("chunk")
    private List<MessageModel> messageModels = new ArrayList<>();
    private String end;

    @Data
    public static class MessageModel {

        private String type;
        private String sender;
        private MessageContentModel content;
        private int age;
    }
}