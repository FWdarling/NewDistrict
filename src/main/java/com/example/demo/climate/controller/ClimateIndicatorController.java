package com.example.demo.climate.controller;

import com.example.demo.climate.dao.DataDicRepo;
import com.example.demo.climate.dao.GroundTemperatureRepo;
import com.example.demo.climate.dao.ObsPositionRepo;
import com.example.demo.climate.entity.Chn2160ObsPosition;
import com.example.demo.climate.entity.DataDic;
import com.example.demo.climate.entity.GroundTemperature;
import com.example.demo.climate.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: ClimateController
 * date: 4/24/21 3:13 PM
 * author: fourwood
 */
@RestController
@RequestMapping(value = "/api/v1/indicator")
public class ClimateIndicatorController {

    @Autowired
    public ClimateIndicatorController(
            GroundTemperatureRepo groundTemperatureRepo,
            DataDicRepo dataDicRepo,
            ObsPositionRepo obsPositionRepo) {
        this.groundTemperatureRepo = groundTemperatureRepo;
        this.dataDicRepo = dataDicRepo;
        this.obsPositionRepo = obsPositionRepo;
    }

    private final GroundTemperatureRepo groundTemperatureRepo;
    private final DataDicRepo dataDicRepo;
    private final ObsPositionRepo obsPositionRepo;

    private static final String DEFAULT_PAGE_SIZE = "500";

    @RequestMapping(value = "/0cm_ground_temperature", method = RequestMethod.GET)
    public ResponseEntity getGroundTemperature(@RequestParam(name = "area")String stationName,
                                               @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                               @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<GroundTemperature> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = groundTemperatureRepo.findGroundTemperatureByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = groundTemperatureRepo.findGroundTemperatureByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("0cm地温");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));

            for(GroundTemperature data : datas){
                if(indicatorNameEn.equals("avg_ground_temperature"))
                    series.datas.add(new ResponseData(data.getcdate(), data.getAvgGroundTemperature()));
                else if(indicatorNameEn.equals("max_ground_temperature"))
                    series.datas.add(new ResponseData(data.getcdate(), data.getMaxGroundTemperature()));
                else if(indicatorNameEn.equals("min_ground_temperature"))
                    series.datas.add(new ResponseData(data.getcdate(), data.getMinGroundTemperature()));
            }
            response.series.add(series);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
