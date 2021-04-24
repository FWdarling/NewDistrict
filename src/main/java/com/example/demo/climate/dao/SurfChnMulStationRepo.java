package com.example.demo.climate.dao;

import com.example.demo.climate.entity.SurfChnMulStation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description: SurfChnMulStationRepo
 * date: 4/24/21 8:32 PM
 * author: fourwood
 */
public interface SurfChnMulStationRepo extends JpaRepository<SurfChnMulStation, Long> {
    SurfChnMulStation findByStationName(String stationName);
}
