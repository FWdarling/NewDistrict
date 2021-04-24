package com.example.demo.climate.dao;

import com.example.demo.climate.entity.DataDic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * description: DataDicRepo
 * date: 4/24/21 3:15 PM
 * author: fourwood
 */
public interface DataDicRepo extends JpaRepository<DataDic, Long> {
    List<DataDic> findDataDicBySubtypeCn(String subtypeCn);

}
