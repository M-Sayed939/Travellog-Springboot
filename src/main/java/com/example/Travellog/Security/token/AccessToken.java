package com.example.Travellog.Security.token;

import com.example.Travellog.User.UserEntity;
import com.example.Travellog.User.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AccessToken {

    @SequenceGenerator(
            name = "access_token_sequence",
            sequenceName = "access_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            generator = "access_token_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private UserRole role;
//    @Column(nullable = false)
//    private LocalDateTime expiresAt;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private UserEntity userEntity;

    public AccessToken(String token,
                       LocalDateTime createdAt,
                       UserEntity userEntity, UserRole role) {
        this.token = token;
        this.createdAt = createdAt;
        this.userEntity = userEntity;
        this.role = role;
    }
}
