package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: GroundTemperature
 * date: 4/24/21 2:46 AM
 * author: fourwood
 */
@Entity
@Table(name = "0cm_ground_temperature")
public class GroundTemperature {
    public GroundTemperature(Long id, String observatoryId, Float latitude, Float longitude, String observationHeight, String year, String month, String day, String avgGroundTemperature, String maxGroundTemperature, String minGroundTemperature, String avgGroundTemperatureCode, String maxGroundTemperatureCode, String minGroundTemperatureCode, String timestamp, String cdate) {
        this.id = id;
        this.observatoryId = observatoryId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observationHeight = observationHeight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.avgGroundTemperature = avgGroundTemperature;
        this.maxGroundTemperature = maxGroundTemperature;
        this.minGroundTemperature = minGroundTemperature;
        this.avgGroundTemperatureCode = avgGroundTemperatureCode;
        this.maxGroundTemperatureCode = maxGroundTemperatureCode;
        this.minGroundTemperatureCode = minGroundTemperatureCode;
        this.timestamp = timestamp;
        this.cdate = cdate;
    }

    public GroundTemperature() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservatoryId() {
        return observatoryId;
    }

    public void setObservatoryId(String observatoryId) {
        this.observatoryId = observatoryId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getObservationHeight() {
        return observationHeight;
    }

    public void setObservationHeight(String observationHeight) {
        this.observationHeight = observationHeight;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAvgGroundTemperature() {
        return avgGroundTemperature;
    }

    public void setAvgGroundTemperature(String avgGroundTemperature) {
        this.avgGroundTemperature = avgGroundTemperature;
    }

    public String getMaxGroundTemperature() {
        return maxGroundTemperature;
    }

    public void setMaxGroundTemperature(String maxGroundTemperature) {
        this.maxGroundTemperature = maxGroundTemperature;
    }

    public String getMinGroundTemperature() {
        return minGroundTemperature;
    }

    public void setMinGroundTemperature(String minGroundTemperature) {
        this.minGroundTemperature = minGroundTemperature;
    }

    public String getAvgGroundTemperatureCode() {
        return avgGroundTemperatureCode;
    }

    public void setAvgGroundTemperatureCode(String avgGroundTemperatureCode) {
        this.avgGroundTemperatureCode = avgGroundTemperatureCode;
    }

    public String getMaxGroundTemperatureCode() {
        return maxGroundTemperatureCode;
    }

    public void setMaxGroundTemperatureCode(String maxGroundTemperatureCode) {
        this.maxGroundTemperatureCode = maxGroundTemperatureCode;
    }

    public String getMinGroundTemperatureCode() {
        return minGroundTemperatureCode;
    }

    public void setMinGroundTemperatureCode(String minGroundTemperatureCode) {
        this.minGroundTemperatureCode = minGroundTemperatureCode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getcdate() {
        return cdate;
    }

    public void setcdate(String cdate) {
        this.cdate = cdate;
    }
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "observatory_id")
    private String observatoryId;
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;
    @Column(name = "observation_height")
    private String observationHeight;
    @Column(name = "year")
    private String year;
    @Column(name = "month")
    private String month;
    @Column(name = "day")
    private String day;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "cdate")
    private String cdate;

    @Column(name = "avg_ground_temperature")
    private String avgGroundTemperature;
    @Column(name = "max_ground_temperature")
    private String maxGroundTemperature;
    @Column(name = "min_ground_temperature")
    private String minGroundTemperature;
    @Column(name = "avg_ground_temperature_code")
    private String avgGroundTemperatureCode;
    @Column(name = "max_ground_temperature_code")
    private String maxGroundTemperatureCode;
    @Column(name = "min_ground_temperature_code")
    private String minGroundTemperatureCode;
}
