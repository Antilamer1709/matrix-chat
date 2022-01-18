package com.test.chat.matrix.mapper;

import com.test.chat.matrix.dto.RoomDto;
import com.test.chat.matrix.model.RoomModel;
import org.mapstruct.Mapper;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = getMapper(RoomMapper.class);

    RoomModel fromDto(RoomDto roomDto);

    RoomDto toDto(RoomModel roomModel);

    default List<RoomDto> toDtoList(List<String> roomIds) {
        return roomIds.stream()
                .map(RoomDto::new)
                .collect(toList());
    }
}