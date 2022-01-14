package com.pip.chat.matrix.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String getTestMessage() {
        return "Hello chat!";
    }
}