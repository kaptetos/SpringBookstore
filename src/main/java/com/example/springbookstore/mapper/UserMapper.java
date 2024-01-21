package com.example.springbookstore.mapper;

import com.example.springbookstore.dto.UserRegistrationRequestDto;
import com.example.springbookstore.dto.UserResponseDto;
import com.example.springbookstore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User requestDtoToEntity(UserRegistrationRequestDto requestDto);

    UserResponseDto entityToDto(User user);
}
