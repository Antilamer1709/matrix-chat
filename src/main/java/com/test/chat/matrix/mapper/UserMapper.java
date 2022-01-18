package com.test.chat.matrix.mapper;

import com.test.chat.matrix.dto.LoginDto;
import com.test.chat.matrix.model.LoginModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = getMapper(UserMapper.class);

    @Mapping(target = "identifier.user", source = "username")
    LoginModel fromDto(LoginDto loginDto);

    LoginDto toDto(LoginModel loginModel);
}