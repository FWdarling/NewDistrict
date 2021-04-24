package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Evaporation;
import com.example.demo.climate.entity.GroundTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: EvaporationRepo
 * date: 4/24/21 5:42 PM
 * author: fourwood
 */
public interface EvaporationRepo extends JpaRepository<Evaporation, Long> {
    List<Evaporation> findByObservatoryIdOrderByCdateDesc(String observatoryId);
    List<Evaporation> findByObservatoryIdAndCdateBetweenOrderByCdateDesc(String observatoryId, String startData, String endData);
}
