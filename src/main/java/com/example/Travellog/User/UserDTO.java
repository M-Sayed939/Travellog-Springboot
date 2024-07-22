package com.example.Travellog.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {
    private final Long id;
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String token;
}
