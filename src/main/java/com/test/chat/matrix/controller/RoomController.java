package com.test.chat.matrix.controller;

import com.test.chat.matrix.dto.RoomDto;
import com.test.chat.matrix.mapper.RoomMapper;
import com.test.chat.matrix.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/joined")
    public List<RoomDto> getJoinedRooms(@RequestHeader("access_token") String accessToken) {
        return RoomMapper.INSTANCE.toDtoList(roomService.getJoinedRooms(accessToken));
    }

    @PostMapping("/create")
    public RoomDto create(@RequestHeader("access_token") String accessToken, @RequestBody RoomDto roomDto) {
        return RoomMapper.INSTANCE.toDto(roomService.create(accessToken, RoomMapper.INSTANCE.fromDto(roomDto)));
    }

    @PostMapping("/join")
    public RoomDto join(@RequestHeader("access_token") String accessToken, @RequestBody RoomDto roomDto) {
        return RoomMapper.INSTANCE.toDto(roomService.join(accessToken, roomDto.getId()));
    }
}