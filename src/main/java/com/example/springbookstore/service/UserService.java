package com.example.springbookstore.service;

import com.example.springbookstore.dto.UserRegistrationRequestDto;
import com.example.springbookstore.entity.User;
import com.example.springbookstore.exception.RegistrationException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(UserRegistrationRequestDto request) throws RegistrationException;
}
