package com.softkali.foodkali.auth.repository;

import com.softkali.foodkali.auth.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByPhoneNumber(String phoneNumber);


}
