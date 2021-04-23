package com.example.demo.dbstatus.controller;

import com.example.demo.dbstatus.dao.DataDictionaryRepo;
import com.example.demo.dbstatus.dao.DataSurveyRepo;
import com.example.demo.dbstatus.entity.DataDictionary;
import com.example.demo.dbstatus.entity.DataSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DataDictionaryRepo dataDictionaryRepo;

    @Autowired
    private DataSurveyRepo dataSurveyRepo;

    @RequestMapping(value = "/")
    public ResponseEntity test(){
        return new ResponseEntity<String>("test succeed!", HttpStatus.OK);
    }

    @RequestMapping(value = "/data_dic")
    public ResponseEntity testOrmDic(){
        List<DataDictionary> dictionaries = dataDictionaryRepo.findAll();
        return new ResponseEntity<>(dictionaries, HttpStatus.OK);
    }

    @RequestMapping(value = "/data_survey")
    public ResponseEntity testOrmSurvey(){
        List<DataSurvey> dataSurveys = dataSurveyRepo.findAll();
        return new ResponseEntity<>(dataSurveys, HttpStatus.OK);
    }
}
