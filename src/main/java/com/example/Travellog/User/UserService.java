package com.example.Travellog.User;

import com.example.Travellog.Destination.DestinationEntity;
import com.example.Travellog.Security.token.AccessToken;
import com.example.Travellog.Security.token.AccessTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final AccessTokenService accessTokenService;


    public void saveUser(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUsername(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("user with email %s not found", email)));
    }

    public boolean authenticate(String email, String password) {
        UserEntity user = userRepository.findByEmail(email).orElse(null);
        return user != null && bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public void signUpUser(UserEntity user) {
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public UserDTO login(UserEntity user) {
        UserEntity user1 = userRepository.findByEmail(user.getEmail()).get();
        String token = UUID.randomUUID().toString();
        AccessToken accessToken = new AccessToken(token, LocalDateTime.now(), user1, user1.getRole());
        accessTokenService.saveAccessToken(accessToken);
        return new UserDTO(user1.getId(),
                user1.getName(),
                user1.getSurname(),
                user1.getUsername(),
                user1.getEmail(),
                token);
    }


    public List<DestinationEntity> getUserDestinations(Long userId) {
        return userRepository.findById(userId).map(UserEntity::getDestinations).orElse(null);
    }
}
