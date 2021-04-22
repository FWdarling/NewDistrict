package com.example.demo.district.dao;

import com.example.demo.district.entity.DataSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataSurveyRepo extends JpaRepository<DataSurvey, Long> {
    List<DataSurvey> findAll();

    List<DataSurvey> findByDataName(String dataName);
}
