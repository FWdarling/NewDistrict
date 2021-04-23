package com.example.demo.dbstatus.controller;

import com.example.demo.dbstatus.dao.DataDictionaryRepo;
import com.example.demo.dbstatus.dao.DataSurveyRepo;
import com.example.demo.dbstatus.entity.DataDictionary;
import com.example.demo.dbstatus.entity.DataSurvey;
import com.example.demo.dbstatus.response.Datas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController {

    @Autowired
    public DataController(DataSurveyRepo dataSurveyRepo, DataDictionaryRepo dataDictionaryRepo){
        this.dataDictionaryRepo = dataDictionaryRepo;
        this.dataSurveyRepo = dataSurveyRepo;
    }

    private final DataSurveyRepo dataSurveyRepo;

    private final DataDictionaryRepo dataDictionaryRepo;

    @RequestMapping(value = "/data_tree", method = RequestMethod.GET)
    public ResponseEntity getDataTree(){
        List<DataDictionary> dictionaries = dataDictionaryRepo.findAll();
        Map<String, Map<String, Datas>> ret = new HashMap<>();
        for(DataDictionary dictionary : dictionaries){
            String typeCn = dictionary.getTypeCn();
            if(!ret.containsKey(typeCn)) {
                ret.put(typeCn, new HashMap<>());
            }
            Map<String, Datas> subtypes = ret.get(typeCn);
            String subtypeCn = dictionary.getSubtypeCn(), subtypeEn = dictionary.getSubtypeEn();
            if(!subtypes.containsKey(subtypeCn)) {
                subtypes.put(subtypeCn, new Datas());
            }
            Datas datas = subtypes.get(subtypeCn);
            datas.setSubtypeEn(subtypeEn);
            String indicatorNameCn = dictionary.getIndicatorNameCn();
            if(!indicatorNameCn.equals("0")) {
                datas.indicators.add(indicatorNameCn);
            }
            List<DataSurvey> dataSurveys = dataSurveyRepo.findByDataName(subtypeCn);
            if(dataSurveys.size() > 0) {
                String count = dataSurveys.get(0).getCurrentNumber();
                datas.setCount(count);
            }
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
