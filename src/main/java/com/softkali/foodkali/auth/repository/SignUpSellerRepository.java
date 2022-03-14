package com.softkali.foodkali.auth.repository;

import com.softkali.foodkali.auth.model.AuthSeller;
import com.softkali.foodkali.auth.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpSellerRepository extends JpaRepository<AuthSeller, Long> {

    Optional<AuthSeller> findByPhoneNumber(String phoneNumber);

}
