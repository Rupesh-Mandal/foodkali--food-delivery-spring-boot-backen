package com.softkali.foodkali.location.service;

import com.softkali.foodkali.location.model.Location;
import com.softkali.foodkali.location.model.addLocation;
import com.softkali.foodkali.location.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Object getAll() {
        return locationRepository.findAll();
    }

    public Object addLocation(addLocation addLocation) {
        Location location=new Location();
        location.setName(addLocation.getName());
        locationRepository.save(location);
        return location;
    }
}
