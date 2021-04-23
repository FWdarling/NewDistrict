package com.example.demo.dbstatus.dao;

import com.example.demo.dbstatus.entity.DataSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataSurveyRepo extends JpaRepository<DataSurvey, Long> {
    List<DataSurvey> findAll();

    List<DataSurvey> findByDataName(String dataName);
}
