package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Humidity;
import com.example.demo.climate.entity.Wind;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: WindRepo
 * date: 4/24/21 6:09 PM
 * author: fourwood
 */
public interface WindRepo extends JpaRepository<Wind, Long> {
    List<Wind> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Wind> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
