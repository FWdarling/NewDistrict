package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Humidity;
import com.example.demo.climate.entity.Sunshine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: SunshineRepo
 * date: 4/24/21 6:08 PM
 * author: fourwood
 */
public interface SunshineRepo extends JpaRepository<Sunshine, Long> {
    List<Sunshine> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Sunshine> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
