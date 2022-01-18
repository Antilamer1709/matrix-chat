package com.test.chat.matrix.dto;

import lombok.Data;

@Data
public class InvitationDto {

    private String roomId;
    private String invitationFrom;
    private String roomName;
}