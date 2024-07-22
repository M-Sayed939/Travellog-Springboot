package com.example.Travellog.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nullable;
import javax.validation.constraints.Email;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String name;
    private final String surname;
    private final String username;
    @Email
    private final String email;
    private final String password;
    private final String country;
    private final String city;
    private final String address;
    private final String phone;
    @Nullable
    private final String role;
}
