package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Humidity;
import com.example.demo.climate.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: TemperatureRepo
 * date: 4/24/21 6:09 PM
 * author: fourwood
 */
public interface TemperatureRepo extends JpaRepository<Temperature, Long> {
    List<Temperature> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Temperature> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
