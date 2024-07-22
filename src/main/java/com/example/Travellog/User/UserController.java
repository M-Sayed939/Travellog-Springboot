package com.example.Travellog.User;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    private final RegisterService registerService;
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserEntity user) {
        if (userService.authenticate(user.getEmail(), user.getPassword())) {
            return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<String> register(@Validated @RequestBody RegistrationRequest request) {
        registerService.register(request);
        return ResponseEntity.ok("user registered successfully");
    }


}
