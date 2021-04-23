package com.example.demo.climate.controller;

import com.example.demo.climate.dao.ClimateTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: TestController
 * date: 4/24/21 2:15 AM
 * author: fourwood
 */
@RestController

public class ClimateTestController {
    private final ClimateTestRepo climateTestRepo;

    @Autowired
    public ClimateTestController(ClimateTestRepo climateTestRepo){
        this.climateTestRepo = climateTestRepo;
    }

    @RequestMapping(value = "/climate")
    public ResponseEntity test(){
        return new ResponseEntity<>(climateTestRepo.findAll(), HttpStatus.OK);
    }
}
