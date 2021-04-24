package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Chn2160ObsPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: ObsPositionRepo
 * date: 4/24/21 3:38 PM
 * author: fourwood
 */
public interface ObsPositionRepo extends JpaRepository<Chn2160ObsPosition, Long> {
    Chn2160ObsPosition findByObservatoryName(String name);
}
