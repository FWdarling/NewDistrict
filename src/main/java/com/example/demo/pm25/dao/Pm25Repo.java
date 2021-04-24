package com.example.demo.pm25.dao;

import com.example.demo.pm25.entity.Pm25;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * description: Pm25Repo
 * date: 4/24/21 10:53 PM
 * author: fourwood
 */
public interface Pm25Repo extends JpaRepository<Pm25, Long> {
    List<Pm25> findByPositionNameOrderByTimePointDesc(String positionName);
    List<Pm25> findByPositionNameAndTimePointBetweenOrderByTimePointDesc(String positionName, Timestamp start, Timestamp end);
    List<Pm25> findByPositionNameLikeOrderByTimePointDesc(String positionName);
    List<Pm25> findByPositionNameLikeAndTimePointBetweenOrderByTimePointDesc(String positionName, Timestamp start, Timestamp end);
}
