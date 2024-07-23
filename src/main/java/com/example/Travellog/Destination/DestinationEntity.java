package com.example.Travellog.Destination;

import com.example.Travellog.User.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    public DestinationEntity(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
