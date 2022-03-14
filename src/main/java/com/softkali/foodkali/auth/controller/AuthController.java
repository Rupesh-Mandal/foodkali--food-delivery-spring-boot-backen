package com.softkali.foodkali.auth.controller;


import com.softkali.foodkali.auth.model.SignInModel;
import com.softkali.foodkali.auth.model.SignUpSellerModel;
import com.softkali.foodkali.auth.model.SignUpUserModel;
import com.softkali.foodkali.auth.service.AuthService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping(path = "sign_up_user")
    public JSONObject signUpUser(@RequestBody SignUpUserModel signUpModel){
        return authService.signUpUser(signUpModel);
    }

    @PostMapping(path = "sign_in_user")
    public JSONObject signInUser(@RequestBody SignInModel signInModel){
        return authService.signInUser(signInModel);
    }

    @PostMapping(path = "sign_up_seller")
    public JSONObject signUpSeller(@RequestBody SignUpSellerModel signUpSellerModel){
        return authService.signSellerUser(signUpSellerModel);
    }

    @PostMapping(path = "sign_in_seller")
    public JSONObject signInSeller(@RequestBody SignInModel signInModel){
        return authService.signInSeller(signInModel);
    }



}
