package com.pip.chat.matrix.controller;

import com.pip.chat.matrix.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public String getTestMessage() {
        return chatService.getTestMessage();
    }
}