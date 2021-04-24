package com.example.demo.pm25.controller;

import com.example.demo.pm25.dao.Pm25Repo;
import com.example.demo.pm25.entity.Pm25;
import com.example.demo.pm25.response.ResponseData;
import com.example.demo.pm25.response.ResponsePm25;
import com.example.demo.pm25.response.ResponsePosition;
import com.example.demo.pm25.response.ResponseSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * description: Pm25Controller
 * date: 4/24/21 11:05 PM
 * author: fourwood
 */
@RestController
@RequestMapping(value = "/api/v1/indicator")
public class Pm25Controller {

    private final Pm25Repo pm25Repo;
    private static final String DEFAULT_PAGE_SIZE = "500";

    @Autowired
    public Pm25Controller(Pm25Repo pm25Repo){
        this.pm25Repo = pm25Repo;
    }

    @RequestMapping(value = "/pm25")
    public ResponseEntity getpm25(@RequestParam(name = "area")String positionName,
                                  @RequestParam(name = "start_time", defaultValue = "2014-01-01 00:00:00") Timestamp startTime, @RequestParam(name = "end_time", defaultValue = "2021-01-01 00:00:00")Timestamp endTime,
                                  @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        List<Pm25> datas;
        if(startTime.equals("") || endTime.equals("")) {
            datas = pm25Repo.findByPositionNameLikeOrderByTimePointDesc("%" + positionName + "%");
        }else {
            datas = pm25Repo.findByPositionNameLikeAndTimePointBetweenOrderByTimePointDesc("%" + positionName + "%", startTime, endTime);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        String area = datas.size() > 0 ?  datas.get(0).getArea() : "";
        ResponsePm25 response = new ResponsePm25(new ResponsePosition(positionName, area), total, datas.size(), pageIndex, pageSize);

        List<String> types = new ArrayList<String>(){{
            add("Aqi");add("Co");add("Co_24h");add("No2");add("No2_24h");
            add("O3_24h");add("O3_8h");add("Pm10");add("Pm10_24h");add("Pm2_5");
            add("Pm2_5_24h");add("Primary_pollutant");add("Quality");add("So2");add("So2_24h");
        }};
        for (String type : types){
            ResponseSeries series = new ResponseSeries(type);
            try{
                Class<?> clazz = Class.forName("com.example.demo.pm25.entity.Pm25");
                Method method = clazz.getMethod("get" + type);
                for(Pm25 data : datas){
                    series.datas.add(new ResponseData(data.getTime_point(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
