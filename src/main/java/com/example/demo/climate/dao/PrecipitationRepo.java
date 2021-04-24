package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Humidity;
import com.example.demo.climate.entity.Precipitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: PrecipitationRepo
 * date: 4/24/21 6:05 PM
 * author: fourwood
 */
public interface PrecipitationRepo extends JpaRepository<Precipitation, Long> {
    List<Precipitation> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Precipitation> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
