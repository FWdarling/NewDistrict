package com.example.demo.climate.dao;

import com.example.demo.climate.entity.SurfChnMulMdayDic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: SurfChnMulMdayDicRepo
 * date: 4/24/21 8:31 PM
 * author: fourwood
 */
public interface SurfChnMulMdayDicRepo extends JpaRepository<SurfChnMulMdayDic, Long> {
    List<SurfChnMulMdayDic> findAll();
}
