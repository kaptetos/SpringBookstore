package com.example.springbookstore.dto;

import lombok.Data;

@Data
public class UserRegistrationRequestDto {
    private String email;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private String shippingAddress;
}
