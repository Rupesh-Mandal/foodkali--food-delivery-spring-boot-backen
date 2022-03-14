package com.softkali.foodkali.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
@ToString
public class SignUpSellerModel {

    private String hotelname;
    private String name;

    private String phoneNumber;
    private String email;
    private String password;

    private String location;
}
