package com.softkali.foodkali.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AuthUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String name;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdTime;

    private String location;

    public AuthUser(String userId, String name, String phoneNumber, String password, LocalDateTime createdTime, String location) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.createdTime = createdTime;
        this.location = location;
    }
}
