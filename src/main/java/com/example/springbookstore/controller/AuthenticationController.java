package com.example.springbookstore.controller;

import com.example.springbookstore.dto.UserRegistrationRequestDto;
import com.example.springbookstore.dto.UserResponseDto;
import com.example.springbookstore.exception.RegistrationException;
import com.example.springbookstore.mapper.UserMapper;
import com.example.springbookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/registration")
    public UserResponseDto register(@RequestBody UserRegistrationRequestDto request) throws RegistrationException {
        return userMapper.entityToDto(userService.registerUser(request));
    }
}
