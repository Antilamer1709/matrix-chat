package com.test.chat.matrix.mapper;

import com.test.chat.matrix.dto.InvitationDto;
import com.test.chat.matrix.model.InviteUserModel;
import com.test.chat.matrix.model.SyncStateModel.RoomInvitationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Objects.nonNull;
import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface InvitationMapper {

    InvitationMapper INSTANCE = getMapper(InvitationMapper.class);

    @Mapping(target = "userId", source = "userId")
    InviteUserModel fromDto(String userId);

    default List<InvitationDto> toDto(RoomInvitationModel roomInvitationModel) {

        if (nonNull(roomInvitationModel)) {
            return roomInvitationModel.getInvite().entrySet().stream()
                    .map(entry -> {
                        InvitationDto invitationDto = new InvitationDto();
                        invitationDto.setRoomId(entry.getKey());

                        invitationDto.setRoomName(entry.getValue().get("invite_state")
                                .get("events")
                                .stream()
                                .filter(event -> event.getType().equals("m.room.name"))
                                .map(RoomInvitationModel.InviteEventModel::getContent)
                                .map(RoomInvitationModel.InviteEventModel.InviteContentModel::getName)
                                .findFirst()
                                .orElse("Unknown room name"));
                        invitationDto.setInvitationFrom(entry.getValue().get("invite_state")
                                .get("events")
                                .stream()
                                .filter(event -> event.getType().equals("m.room.create"))
                                .map(RoomInvitationModel.InviteEventModel::getContent)
                                .map(RoomInvitationModel.InviteEventModel.InviteContentModel::getCreator)
                                .findFirst()
                                .orElse("Unknown room name"));
                        return invitationDto;
                    }).collect(Collectors.toList());
        }
        return emptyList();
    }
}