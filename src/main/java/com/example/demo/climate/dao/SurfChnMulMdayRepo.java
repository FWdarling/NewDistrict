package com.example.demo.climate.dao;

import com.example.demo.climate.entity.SurfChnMulMday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: SurfChnMulMdayRepo
 * date: 4/24/21 8:26 PM
 * author: fourwood
 */
public interface SurfChnMulMdayRepo extends JpaRepository<SurfChnMulMday, Long> {
    List<SurfChnMulMday> findByStationId(String stationId);
}
