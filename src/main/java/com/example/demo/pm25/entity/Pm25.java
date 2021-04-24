package com.example.demo.pm25.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * description: Pm25
 * date: 4/24/21 10:03 PM
 * author: fourwood
 */
@Entity
@Table(name = "pm25")
public class Pm25 {
    public Pm25() {
    }

    public Pm25(Long id, Long aqi, String area, Float co, Float co_24h, Long no2, Long no2_24h, Long o3, Long o3_24h, Long o3_8h, Long pm10, Long pm10_24h, Long pm2_5, Long pm2_5_24h, String position_name, String primary_pollutant, String quality, Long so2, Long so2_24h, String station_code, Timestamp time_point) {
        this.id = id;
        this.aqi = aqi;
        this.area = area;
        this.co = co;
        this.co_24h = co_24h;
        this.no2 = no2;
        this.no2_24h = no2_24h;
        this.o3 = o3;
        this.o3_24h = o3_24h;
        this.o3_8h = o3_8h;
        this.pm10 = pm10;
        this.pm10_24h = pm10_24h;
        this.pm2_5 = pm2_5;
        this.pm2_5_24h = pm2_5_24h;
        this.positionName = position_name;
        this.primary_pollutant = primary_pollutant;
        this.quality = quality;
        this.so2 = so2;
        this.so2_24h = so2_24h;
        this.station_code = station_code;
        this.timePoint = time_point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAqi() {
        return aqi;
    }

    public void setAqi(Long aqi) {
        this.aqi = aqi;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Float getCo() {
        return co;
    }

    public void setCo(Float co) {
        this.co = co;
    }

    public Float getCo_24h() {
        return co_24h;
    }

    public void setCo_24h(Float co_24h) {
        this.co_24h = co_24h;
    }

    public Long getNo2() {
        return no2;
    }

    public void setNo2(Long no2) {
        this.no2 = no2;
    }

    public Long getNo2_24h() {
        return no2_24h;
    }

    public void setNo2_24h(Long no2_24h) {
        this.no2_24h = no2_24h;
    }

    public Long getO3() {
        return o3;
    }

    public void setO3(Long o3) {
        this.o3 = o3;
    }

    public Long getO3_24h() {
        return o3_24h;
    }

    public void setO3_24h(Long o3_24h) {
        this.o3_24h = o3_24h;
    }

    public Long getO3_8h() {
        return o3_8h;
    }

    public void setO3_8h(Long o3_8h) {
        this.o3_8h = o3_8h;
    }

    public Long getPm10() {
        return pm10;
    }

    public void setPm10(Long pm10) {
        this.pm10 = pm10;
    }

    public Long getPm10_24h() {
        return pm10_24h;
    }

    public void setPm10_24h(Long pm10_24h) {
        this.pm10_24h = pm10_24h;
    }

    public Long getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Long pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public Long getPm2_5_24h() {
        return pm2_5_24h;
    }

    public void setPm2_5_24h(Long pm2_5_24h) {
        this.pm2_5_24h = pm2_5_24h;
    }

    public String getPosition_name() {
        return positionName;
    }

    public void setPosition_name(String position_name) {
        this.positionName = position_name;
    }

    public String getPrimary_pollutant() {
        return primary_pollutant;
    }

    public void setPrimary_pollutant(String primary_pollutant) {
        this.primary_pollutant = primary_pollutant;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Long getSo2() {
        return so2;
    }

    public void setSo2(Long so2) {
        this.so2 = so2;
    }

    public Long getSo2_24h() {
        return so2_24h;
    }

    public void setSo2_24h(Long so2_24h) {
        this.so2_24h = so2_24h;
    }

    public String getStation_code() {
        return station_code;
    }

    public void setStation_code(String station_code) {
        this.station_code = station_code;
    }

    public Timestamp getTime_point() {
        return timePoint;
    }

    public void setTime_point(Timestamp time_point) {
        this.timePoint = time_point;
    }

    @Id
    private Long id;
    private Long aqi;
    private String area;
    private Float co;
    private Float co_24h;
    private Long no2;
    private Long no2_24h;
    private Long o3;
    private Long o3_24h;
    private Long o3_8h;
    private Long pm10;
    private Long pm10_24h;
    private Long pm2_5;
    private Long pm2_5_24h;
    @Column(name = "position_name")
    private String positionName;
    private String primary_pollutant;
    private String quality;
    private Long so2;
    private Long so2_24h;
    private String station_code;
    @Column(name = "time_point",columnDefinition = "timestamp")
    private Timestamp timePoint;
}
