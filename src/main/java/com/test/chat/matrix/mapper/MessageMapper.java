package com.test.chat.matrix.mapper;

import com.test.chat.matrix.dto.ChatDto;
import com.test.chat.matrix.dto.MessageContentDto;
import com.test.chat.matrix.dto.MessageDto;
import com.test.chat.matrix.model.ChatModel;
import com.test.chat.matrix.model.MessageContentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;
import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface MessageMapper {

    MessageMapper INSTANCE = getMapper(MessageMapper.class);

    MessageContentModel fromDto(MessageContentDto messageContentDto);

    MessageContentDto toDto(MessageContentModel messageContentModel);

    @Mapping(target = "dateTime", source = "age")
    MessageDto toDto(ChatModel.MessageModel messageModel);

    @Mapping(target = "messages", source = "messageModels")
    ChatDto toDto(ChatModel chatModel);

    default LocalDateTime toLocalDateTime(int age) {
        return now().minus(age, MILLIS);
    }
}