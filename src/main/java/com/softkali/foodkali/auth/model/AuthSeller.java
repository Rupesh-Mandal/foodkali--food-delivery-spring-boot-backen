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
public class AuthSeller {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sellerId;

    private String hotelname;
    private String name;

    private String phoneNumber;
    private String email;

    private String password;
    private LocalDateTime createdTime;

    private String location;

    public AuthSeller(String sellerId, String hotelname, String name, String phoneNumber, String email, String password, LocalDateTime createdTime, String location) {
        this.sellerId = sellerId;
        this.hotelname = hotelname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.createdTime = createdTime;
        this.location = location;
    }
}
