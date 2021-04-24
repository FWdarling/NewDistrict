package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Evaporation;
import com.example.demo.climate.entity.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: HumidityRepo
 * date: 4/24/21 5:51 PM
 * author: fourwood
 */
public interface HumidityRepo extends JpaRepository<Humidity, Long> {
    List<Humidity> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Humidity> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
