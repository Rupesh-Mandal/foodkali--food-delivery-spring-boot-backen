package com.softkali.foodkali.location.repository;

import com.softkali.foodkali.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
