package com.test.chat.matrix.controller;

import com.test.chat.matrix.dto.InvitationDto;
import com.test.chat.matrix.mapper.InvitationMapper;
import com.test.chat.matrix.service.InvitationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitation")
@AllArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @GetMapping("/")
    public List<InvitationDto> getInvitations(@RequestHeader("access_token") String accessToken) {
        return InvitationMapper.INSTANCE.toDto(invitationService.getAllInvitations(accessToken));
    }

    @PostMapping("/{userId}/{roomId}")
    public void inviteUser(@RequestHeader("access_token") String accessToken, @PathVariable String userId, @PathVariable String roomId) {
        invitationService.inviteUser(accessToken, roomId, InvitationMapper.INSTANCE.fromDto(userId));
    }
}