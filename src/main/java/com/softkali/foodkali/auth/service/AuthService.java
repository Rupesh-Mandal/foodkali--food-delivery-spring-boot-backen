package com.softkali.foodkali.auth.service;

import com.softkali.foodkali.auth.model.*;
import com.softkali.foodkali.auth.repository.SignUpSellerRepository;
import com.softkali.foodkali.auth.repository.SignUpUserRepository;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final SignUpUserRepository signUpUserRepository;
    private final SignUpSellerRepository signUpSellerRepository;


    public JSONObject signUpUser(SignUpUserModel signUpUserModel) {
        JSONObject jsonObject = new JSONObject();
        boolean userExists = signUpUserRepository.findByPhoneNumber(signUpUserModel.getPhoneNumber()).isPresent();

        if (userExists) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "PhoneNumber already taken");
            return jsonObject;
        }
        String userId= UUID.randomUUID().toString();

        AuthUser authUser = new AuthUser(userId,signUpUserModel.getName(),signUpUserModel.getPhoneNumber(),
                signUpUserModel.getPassword(),LocalDateTime.now(),signUpUserModel.getLocation());
        Long status = signUpUserRepository.save(authUser).getId();
        if (status == null) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "SignUp Faild");
            return jsonObject;
        }
        jsonObject.put("status", true);
        jsonObject.put("messag", "User Succefully SignUp");
        jsonObject.put("data",authUser);

        return jsonObject;
    }

    public JSONObject signInUser(SignInModel signInModel) {
        JSONObject jsonObject = new JSONObject();
        Optional<AuthUser> authUserOptional=signUpUserRepository.findByPhoneNumber(signInModel.getPhoneNumber());

        if (authUserOptional.isPresent()) {
            AuthUser authUser = authUserOptional.get();
            if (authUser.getPassword().equals(signInModel.getPassword())){
                jsonObject.put("status", true);
                jsonObject.put("messag", "You are loged in");

                jsonObject.put("data",authUser);
                return jsonObject;
            }else {
                jsonObject.put("status", false);
                jsonObject.put("messag", "Please Provide Correct Password");
                return jsonObject;
            }



        } else {
            jsonObject.put("status", false);
            jsonObject.put("messag", "You are not a register user");
            return jsonObject;
        }
    }

    public JSONObject signSellerUser(SignUpSellerModel signUpSellerModel) {
        JSONObject jsonObject = new JSONObject();
        boolean userExists = signUpSellerRepository.findByPhoneNumber(signUpSellerModel.getPhoneNumber()).isPresent();

        if (userExists) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "PhoneNumber already taken");
            return jsonObject;
        }
        String sellerId= UUID.randomUUID().toString();

        AuthSeller authSeller = new AuthSeller(sellerId,signUpSellerModel.getHotelname(),signUpSellerModel.getName(),signUpSellerModel.getPhoneNumber(),
                signUpSellerModel.getEmail(),
                signUpSellerModel.getPassword(), LocalDateTime.now(),signUpSellerModel.getLocation());
        Long status = signUpSellerRepository.save(authSeller).getId();
        if (status == null) {
            jsonObject.put("status", false);
            jsonObject.put("messag", "SignUp Faild");
            return jsonObject;
        }
        jsonObject.put("status", true);
        jsonObject.put("messag", "User Succefully SignUp");
        jsonObject.put("data",authSeller);

        return jsonObject;
    }

    public JSONObject signInSeller(SignInModel signInModel) {
        JSONObject jsonObject = new JSONObject();
        Optional<AuthSeller> authUserOptional=signUpSellerRepository.findByPhoneNumber(signInModel.getPhoneNumber());

        if (authUserOptional.isPresent()) {
            AuthSeller authSeller = authUserOptional.get();
            if (authSeller.getPassword().equals(signInModel.getPassword())){
                jsonObject.put("status", true);
                jsonObject.put("messag", "You are loged in");

                jsonObject.put("data",authSeller);
                return jsonObject;
            }else {
                jsonObject.put("status", false);
                jsonObject.put("messag", "Please Provide Correct Password");
                return jsonObject;
            }



        } else {
            jsonObject.put("status", false);
            jsonObject.put("messag", "You are not a register user");
            return jsonObject;
        }
    }
}
