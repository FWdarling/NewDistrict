package com.example.demo.climate.controller;

import com.example.demo.climate.dao.GroundTemperatureRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: ClimateController
 * date: 4/24/21 3:13 PM
 * author: fourwood
 */
@RestController
@RequestMapping(value = "/api/v1/indicator")
public class ClimateIndicatorController {

    private GroundTemperatureRepo groundTemperatureRepo;
}
