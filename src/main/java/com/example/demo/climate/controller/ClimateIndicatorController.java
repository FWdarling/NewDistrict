package com.example.demo.climate.controller;

import com.example.demo.climate.dao.*;
import com.example.demo.climate.entity.*;
import com.example.demo.climate.response.*;
import com.example.demo.utils.MethodFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.Sun;

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
            ObsPositionRepo obsPositionRepo,
            EvaporationRepo evaporationRepo,
            HumidityRepo humidityRepo,
            PrecipitationRepo precipitationRepo,
            PressureRepo pressureRepo,
            SunshineRepo sunshineRepo,
            TemperatureRepo temperatureRepo,
            WindRepo windRepo,
            SurfChnMulMdayRepo surfChnMulMdayRepo,
            SurfChnMulStationRepo surfChnMulStationRepo,
            SurfChnMulMdayDicRepo surfChnMulMdayDicRepo) {
        this.groundTemperatureRepo = groundTemperatureRepo;
        this.dataDicRepo = dataDicRepo;
        this.obsPositionRepo = obsPositionRepo;
        this.evaporationRepo = evaporationRepo;
        this.humidityRepo = humidityRepo;
        this.precipitationRepo = precipitationRepo;
        this.pressureRepo = pressureRepo;
        this.sunshineRepo = sunshineRepo;
        this.temperatureRepo = temperatureRepo;
        this.windRepo = windRepo;
        this.surfChnMulMdayRepo = surfChnMulMdayRepo;
        this.surfChnMulMdayDicRepo = surfChnMulMdayDicRepo;
        this.surfChnMulStationRepo = surfChnMulStationRepo;
    }

    private final DataDicRepo dataDicRepo;
    private final ObsPositionRepo obsPositionRepo;
    private final GroundTemperatureRepo groundTemperatureRepo;
    private final EvaporationRepo evaporationRepo;
    private final HumidityRepo humidityRepo;
    private final PrecipitationRepo precipitationRepo;
    private final PressureRepo pressureRepo;
    private final SunshineRepo sunshineRepo;
    private final TemperatureRepo temperatureRepo;
    private final WindRepo windRepo;
    private final SurfChnMulMdayRepo surfChnMulMdayRepo;
    private final SurfChnMulStationRepo surfChnMulStationRepo;
    private final SurfChnMulMdayDicRepo surfChnMulMdayDicRepo;

    private static final String DEFAULT_PAGE_SIZE = "500";
    private static final Map<String, String> CLASS_NAME = new HashMap<>();

    static{
        CLASS_NAME.put("0cm_ground_temperature", "com.example.demo.climate.entity.GroundTemperature");
        CLASS_NAME.put("evaporation", "com.example.demo.climate.entity.Evaporation");
        CLASS_NAME.put("humidity", "com.example.demo.climate.entity.Humidity");
        CLASS_NAME.put("pressure", "com.example.demo.climate.entity.Pressure");
        CLASS_NAME.put("precipitation", "com.example.demo.climate.entity.Precipitation");
        CLASS_NAME.put("sunshine", "com.example.demo.climate.entity.Sunshine");
        CLASS_NAME.put("temperature", "com.example.demo.climate.entity.Temperature");
        CLASS_NAME.put("wind", "com.example.demo.climate.entity.Wind");
        CLASS_NAME.put("SURF_CHN_MUL_MDAY", "com.example.demo.climate.entity.SurfChnMulMday");
    }

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
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("0cm_ground_temperature"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(GroundTemperature data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/evaporation", method = RequestMethod.GET)
    public ResponseEntity getEvaporation(@RequestParam(name = "area")String stationName,
                                               @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                               @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Evaporation> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = evaporationRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = evaporationRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("蒸发");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("evaporation"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Evaporation data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/humidity", method = RequestMethod.GET)
    public ResponseEntity getHumidity(@RequestParam(name = "area")String stationName,
                                         @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                         @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Humidity> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = humidityRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = humidityRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("相对湿度");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("humidity"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Humidity data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/precipitation", method = RequestMethod.GET)
    public ResponseEntity getPrecipitation(@RequestParam(name = "area")String stationName,
                                         @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                         @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Precipitation> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = precipitationRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = precipitationRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("降水量");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("precipitation"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Precipitation data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/pressure", method = RequestMethod.GET)
    public ResponseEntity getPressure(@RequestParam(name = "area")String stationName,
                                         @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                         @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Pressure> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = pressureRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = pressureRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("本站气压");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("pressure"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Pressure data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/sunshine", method = RequestMethod.GET)
    public ResponseEntity getSunshine(@RequestParam(name = "area")String stationName,
                                         @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                         @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Sunshine> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = sunshineRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = sunshineRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("日照时数");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("sunshine"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Sunshine data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/temperature", method = RequestMethod.GET)
    public ResponseEntity getTemperature(@RequestParam(name = "area")String stationName,
                                         @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                         @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Temperature> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = temperatureRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = temperatureRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("气温");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("temperature"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Temperature data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/wind", method = RequestMethod.GET)
    public ResponseEntity getWind(@RequestParam(name = "area")String stationName,
                                         @RequestParam(name = "start_date", defaultValue = "") String startDate, @RequestParam(name = "end_date", defaultValue = "")String endDate,
                                         @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        Chn2160ObsPosition station = obsPositionRepo.findByObservatoryName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<Wind> datas;
        if("".equals(startDate) || "".equals(endDate)) {
            datas = windRepo.findByObservatoryIdOrderByCdateDesc(station.getObservatoryId());
        }else {
            datas = windRepo.findByObservatoryIdAndCdateBetweenOrderByCdateDesc(station.getObservatoryId(), startDate, endDate);
        }

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<DataDic> types = dataDicRepo.findDataDicBySubtypeCn("风向风速");
        for (DataDic type : types){
            String indicatorNameEn = type.getIndicatorNameEn();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("wind"));
                Method method = clazz.getMethod("get" + MethodFormatUtil.toCamelCase(indicatorNameEn));
                for(Wind data : datas){
                    series.datas.add(new ResponseData(data.getCdate(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/SURF_CHN_MUL_MDAY", method = RequestMethod.GET)
    public ResponseEntity getSurf(@RequestParam(name = "area")String stationName,
                                  @RequestParam(name = "page_index", defaultValue = "0")int pageIndex, @RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE)int pageSize){
        SurfChnMulStation station = surfChnMulStationRepo.findByStationName(stationName);
        if(station == null) return new ResponseEntity<>("observatory not found!", HttpStatus.NOT_FOUND);

        List<SurfChnMulMday> datas = surfChnMulMdayRepo.findByStationId(station.getStationId());

        int total = datas.size();
        if(pageIndex * pageSize > total) return new ResponseEntity<>("page overflow!", HttpStatus.BAD_REQUEST);
        datas = datas.subList(pageIndex * pageSize, Math.min(total, (pageIndex + 1) * pageSize));

        ResponseClimate response = new ResponseClimate(new ResponseStation(station));
        response.total = total;
        response.count = datas.size();
        response.pageSize = pageSize;
        response.pageNum = pageIndex;

        List<SurfChnMulMdayDic> types = surfChnMulMdayDicRepo.findAll();
        for (SurfChnMulMdayDic type : types){
            String indicatorCode = type.getIndicatorCode();
            ResponseSeries series = new ResponseSeries(new ResponseIndicator(type));
            try{
                Class<?> clazz = Class.forName(CLASS_NAME.get("SURF_CHN_MUL_MDAY"));
                Method method = clazz.getMethod(MethodFormatUtil.surfMethod(indicatorCode));
                for(SurfChnMulMday data : datas){
                    series.datas.add(new ResponseData(data.getVTimeAvaila() + "_" + data.getV04292(), method.invoke(data).toString()));
                }
                response.series.add(series);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
