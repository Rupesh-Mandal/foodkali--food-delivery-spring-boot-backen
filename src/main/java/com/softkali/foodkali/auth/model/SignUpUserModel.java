package com.softkali.foodkali.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
@ToString
public class SignUpUserModel {
    private String name;
    private String phoneNumber;
    private String password;

    private String location;
}
