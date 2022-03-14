package com.softkali.foodkali.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SignInModel {
    private String phoneNumber;
    private String password;

}
