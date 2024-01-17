package com.example.springbookstore.service;

import com.example.springbookstore.dto.UserRegistrationRequestDto;
import com.example.springbookstore.entity.User;
import com.example.springbookstore.exception.RegistrationException;
import com.example.springbookstore.mapper.UserMapper;
import com.example.springbookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserRegistrationRequestDto request) throws RegistrationException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RegistrationException("A user with this email is already registered");
        }

        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new RegistrationException("Password and password confirmation do not match");
        }

        User user = userMapper.requestDtoToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
