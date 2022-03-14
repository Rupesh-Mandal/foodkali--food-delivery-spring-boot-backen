package com.softkali.foodkali.location.controller;

import com.softkali.foodkali.location.model.addLocation;
import com.softkali.foodkali.location.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/location")
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping(path = "get_all")
    public Object getAll(){
        return locationService.getAll();
    }

    @PostMapping(path = "add")
    public Object addLocation(@RequestBody addLocation addLocation){
        return locationService.addLocation(addLocation);
    }
}
