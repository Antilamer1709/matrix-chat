package com.test.chat.matrix.controller;

import com.test.chat.matrix.dto.LoginDto;
import com.test.chat.matrix.mapper.UserMapper;
import com.test.chat.matrix.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public LoginDto login(@RequestBody LoginDto loginDto) {
        return UserMapper.INSTANCE.toDto(userService.login(UserMapper.INSTANCE.fromDto(loginDto)));
    }
}