package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Humidity;
import com.example.demo.climate.entity.Pressure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: PressureRepo
 * date: 4/24/21 6:07 PM
 * author: fourwood
 */
public interface PressureRepo extends JpaRepository<Pressure, Long> {
    List<Pressure> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Pressure> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
