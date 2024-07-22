package com.example.Travellog.User;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {
    private final UserService userService;
    public void register(RegistrationRequest request) {

        userService.signUpUser(
                new UserEntity(
                        request.getName(),
                        request.getSurname(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getCountry(),
                        request.getCity(),
                        request.getAddress(),
                        request.getPhone(),
                        request.getRole()==null?UserRole.USER:UserRole.valueOf(request.getRole())

                )
        );
    }
}
