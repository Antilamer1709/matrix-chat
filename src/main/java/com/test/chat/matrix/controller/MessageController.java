package com.test.chat.matrix.controller;

import com.test.chat.matrix.dto.ChatDto;
import com.test.chat.matrix.dto.MessageContentDto;
import com.test.chat.matrix.mapper.MessageMapper;
import com.test.chat.matrix.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/{roomId}")
    public ChatDto getChat(@RequestHeader("access_token") String accessToken, @PathVariable String roomId, @RequestParam(required = false) String previousBatchEnd) {
        return MessageMapper.INSTANCE.toDto(messageService.getAll(accessToken, roomId, previousBatchEnd));
    }

    @PostMapping("/message")
    public MessageContentDto send(@RequestHeader("access_token") String accessToken, @RequestBody MessageContentDto messageContentDto) {
        return MessageMapper.INSTANCE.toDto(messageService.send(accessToken, MessageMapper.INSTANCE.fromDto(messageContentDto)));
    }
}