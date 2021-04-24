package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: SurfChnMulStation
 * date: 4/24/21 1:04 PM
 * author: fourwood
 */
@Entity
@Table(name = "SURF_CHN_MUL_STATION")
public class SurfChnMulStation {
    public SurfChnMulStation() {
    }


    public SurfChnMulStation(Long id, String stationId, String province, String stationName, String longitude, String latitude) {
        this.id = id;
        this.stationId = stationId;
        this.province = province;
        this.stationName = stationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "station_id")
    private String stationId;
    @Column(name = "province")
    private String province;
    @Column(name = "station_name")
    private String stationName;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
}
