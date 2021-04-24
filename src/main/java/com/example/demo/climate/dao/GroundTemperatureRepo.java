package com.example.demo.climate.dao;

import com.example.demo.climate.entity.GroundTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: GroundTemperatureRepo
 * date: 4/24/21 3:04 PM
 * author: fourwood
 */
public interface GroundTemperatureRepo extends JpaRepository<GroundTemperature, Long> {
    List<GroundTemperature> findGroundTemperatureByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<GroundTemperature> findGroundTemperatureByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
