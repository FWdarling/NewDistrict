package com.example.demo.climate.response;

import com.example.demo.climate.entity.Chn2160ObsPosition;
import com.example.demo.climate.entity.SurfChnMulStation;

/**
 * description: ResponseStation
 * date: 4/24/21 4:15 PM
 * author: fourwood
 */
public class ResponseStation {

    public ResponseStation() {
    }

    public ResponseStation(String stationId, String province, String stationName) {
        this.stationId = stationId;
        this.province = province;
        this.stationName = stationName;
    }

    public ResponseStation(Chn2160ObsPosition station){
        this.stationId = station.getObservatoryId();
        this.province = station.getProvince();
        this.stationName = station.getObservatoryName();
    }

    public ResponseStation(SurfChnMulStation station){
        this.stationId = station.getObservatoryId();
        this.province = station.getProvince();
        this.stationName = station.getObservatoryName();
    }

    public String stationId;
    public String province;
    public String stationName;
}
